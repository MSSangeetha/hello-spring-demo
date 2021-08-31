package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
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
//    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }


    //Handles (Query parameters) request of the form /hello?name=LaunchCode
    //Method with Parameters
//    @GetMapping("hello")
//    @PostMapping("hello")
    @RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
    //lives in /hello/hello
    public String helloWithQueryParam(@RequestParam String name){
    return "Hello Query Parameter " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
    return "Darling " + name + "!";
    }

    //Controllers with Form
    //lives in /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='pet-select'>"+
    "<option value='english'>English</option>"+
                "<option value='french'>French</option>"+
                "<option value='italian'>Italian</option>"+
                "<option value='spanish'>Spanish</option>"+
                "<option value='german'>German</option>"+
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

    }

//Method with new Hello
//@GetMapping("message")
//@RequestMapping(method=RequestMethod.POST)
@RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name,@RequestParam String language){
    if(name==""){
        name="World";
    }

        return createMessage(name, language);

    }


    //New method with custom create message

    public String createMessage(String n,String l){
        String greeting = "";
    if(l.equals("english")){
        greeting = "Hello";
    }else if (l.equals("french")) {
        greeting = "Bonjour";
    }
    else if (l.equals("italian")) {
        greeting = "Bonjourno";
    }
    else if (l.equals("spanish")) {
        greeting = "Hola";
    }
    else if (l.equals("german")) {
        greeting = "Hallo";
    }
    return "<html>" +
            "<body style='background-color:red'>" +
            " <p style='color:blue;font-size:46px'>" + greeting + " " + n + "</p>" +
            "</body>" +
            "</html>";
    }
}
