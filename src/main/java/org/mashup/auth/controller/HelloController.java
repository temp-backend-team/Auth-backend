package org.mashup.auth.controller;

import com.google.gson.Gson;
import org.mashup.auth.controller.command.HelloCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {

    @RequestMapping("/hello_spring_boot")
    public String helloWorld(@RequestBody @Valid HelloCommand command) {
        Gson gson = new Gson();
        return gson.toJson(command);
    }
}
