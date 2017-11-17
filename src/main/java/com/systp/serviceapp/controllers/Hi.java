package com.systp.serviceapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hi {
    @GetMapping("/")
    public String hi(){
        return "проверка кодировки тупа";
        }

}
