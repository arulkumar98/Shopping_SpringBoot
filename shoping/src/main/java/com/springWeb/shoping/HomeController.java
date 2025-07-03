package com.springWeb.shoping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @RequestMapping("/home")
    public String greet(){
        return "we to shopping world";
    }

    @RequestMapping("/about")
    public String about(){
        return "It's a shopping website";
    }
}
