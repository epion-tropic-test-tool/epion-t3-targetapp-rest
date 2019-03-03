package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.controller;

import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.model.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value = "todos")
@Slf4j
public class TodosController {

    @PostMapping
    public ResponseEntity<Todo> create(
            @RequestBody @Validated Todo todo) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
