package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.controller;

import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.model.Todo;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.mapper.TodoMapper;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.model.TodoModel;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service.TodoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "todo")
public class TodoController {

    @Autowired
    private TodoCrudService todoCrudService;

    @Autowired
    private TodoMapper todoMapper;

    /**
     * トップ画面表示
     * @param mav
     * @return トップ画面表示
     */
    @GetMapping(value = "/")
    public ModelAndView index(ModelAndView mav) {

        mav.setViewName("index");
        return mav;
    }

    /**
     * 参照画面表示
     * @param mav
     * @return 検索画面表示
     */
    @GetMapping(value = "refer")
    public ModelAndView refer(ModelAndView mav){

        List<TodoModel> todos = todoMapper.selectAll();

        mav.addObject("todos", todos);
        mav.setViewName("refer");
        return mav;
    }

    /**
     * 参照結果画面表示
     * @param todoId
     * @param mav
     * @return 参照結果画面表示
     */
    @GetMapping(value = "result")
    public ModelAndView referResult(@RequestParam("todoId") String todoId, ModelAndView mav) {

        Todo todo = todoCrudService.refer(todoId);

        mav.addObject("todo", todo);
        mav.setViewName("todo");
        return mav;
    }

    /**
     * 登録画面表示
     * @param mav
     * @return 登録画面表示
     */
    @GetMapping(value = "regist")
    public ModelAndView resist(ModelAndView mav){

        mav.setViewName("regist");
        return mav;
    }

    /**
     * 登録画面表示
     * @param title タイトル
     * @param description 詳細
     * @param startTime 開始日時
     * @param due 終了日時
     * @param priority 優先度
     * @param mav
     * @return 参照画面表示
     * @throws ParseException
     */
    @PostMapping(value = "regist")
    public ModelAndView resist(@RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("startTime") String startTime,
                               @RequestParam("due") String due,
                               @RequestParam("priority") String priority,
                               ModelAndView mav) throws ParseException {

        Todo todo = new Todo();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        todo.setTitle(title);
        todo.setDescription(description);
        todo.setPriority(Integer.valueOf(priority));
        todo.setStart(OffsetDateTime.parse(startTime + "+09:00"));
        todo.setDue(OffsetDateTime.parse(due + "+09:00"));

        todoCrudService.create(todo);

        mav.setViewName("redirect:/todo/refer");
        return mav;
    }

}
