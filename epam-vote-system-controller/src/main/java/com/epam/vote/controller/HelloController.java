package com.epam.vote.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class print Hello world by url /api.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 04, 2021
 * @author Sapar.
 */

@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(){
        return "Hello world.";

    }
}