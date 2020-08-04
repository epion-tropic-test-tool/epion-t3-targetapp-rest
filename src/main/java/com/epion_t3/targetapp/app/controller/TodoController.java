package com.epion_t3.targetapp.app.controller;

import com.epion_t3.targetapp.app.bean.RegistForm;
import com.epion_t3.targetapp.app.bean.Todo;
import com.epion_t3.targetapp.domain.mapper.TodoMapper;
import com.epion_t3.targetapp.domain.model.TodoModel;
import com.epion_t3.targetapp.domain.service.TodoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.OffsetDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "todo")
public class TodoController {

    @Autowired
    TodoCrudService todoCrudService;

    @Autowired
    TodoMapper todoMapper;

    /**
     * トップ画面表示
     *
     * @param mav
     * @return トップ画面表示
     */
    @GetMapping
    public ModelAndView index(ModelAndView mav) {

        mav.setViewName("pages/index");
        return mav;
    }

    /**
     * 参照画面表示
     *
     * @param mav
     * @return 検索画面表示
     */
    @GetMapping(value = "refer")
    public ModelAndView refer(ModelAndView mav) {

        List<TodoModel> todos = todoMapper.selectAll();

        mav.addObject("todos", todos);
        mav.setViewName("pages/refer");
        return mav;
    }

    /**
     * 参照結果画面表示
     *
     * @param todoId
     * @param mav
     * @return 参照結果画面表示
     */
    @GetMapping(value = "result")
    public ModelAndView referResult(@RequestParam("todoId") String todoId, ModelAndView mav) {

        Todo todo = todoCrudService.refer(todoId);

        mav.addObject("todo", todo);
        mav.setViewName("pages/todo");
        return mav;
    }

    /**
     * 登録画面表示
     *
     * @param mav
     * @return 登録画面表示
     */
    @GetMapping(value = "regist")
    public ModelAndView resist(@ModelAttribute("registForm") RegistForm registForm, ModelAndView mav) {

        mav.setViewName("pages/regist");
        return mav;
    }

    /**
     * 登録画面表示
     *
     * @param mav
     * @return 参照画面表示
     * @throws ParseException
     */
    @PostMapping(value = "regist")
    public ModelAndView regist(@ModelAttribute("registForm") RegistForm registForm, ModelAndView mav) throws ParseException {

        Todo todo = new Todo();

        todo.setTitle(registForm.getTitle());
        todo.setDescription(registForm.getDescription());
        todo.setPriority(Integer.valueOf(registForm.getPriority()));
        todo.setStart(OffsetDateTime.parse(registForm.getStart() + "+09:00"));
        todo.setDue(OffsetDateTime.parse(registForm.getDue() + "+09:00"));

        todoCrudService.create(todo);

        mav.setViewName("redirect:/todo/refer");
        return mav;
    }

}
