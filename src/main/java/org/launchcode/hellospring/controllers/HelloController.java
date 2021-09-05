package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller

@RequestMapping("hello")
public class HelloController{

    //First Method
    //specified Springboot that this method only handles get requests
    //Handles request at path /hello
//    @GetMapping("hello")
//    //tells that the method returns a string
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Second Method
    //lives in /hello/goodbye
    @GetMapping("goodbye")
    //tells that the method returns a string
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }


    //Handles (Query parameters) request of the form /hello?name=LaunchCode
    //Method with Parameters
//    @GetMapping("hello")
//    @PostMapping("hello")
    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    //lives in /hello/hello
    public String helloWithQueryParam(@RequestParam String name){
    return "Hello Query Parameter " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
    return "Darling " + name + "!";
    }

    //Controllers with Form
    //lives in /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "form";

    }
}
