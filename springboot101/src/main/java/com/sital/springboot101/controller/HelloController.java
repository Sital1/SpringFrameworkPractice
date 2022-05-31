package com.sital.springboot101.controller;

import com.sital.springboot101.dto.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody // don't search for static. Can be placed above the class.
    public String hello() {
        // searches for a static page.
        return "Hello";
    }

        /*
    Using Path variable.
    */


    @RequestMapping(method = RequestMethod.GET, path = "/helloworld/{name}")
    public String helloWorld(@PathVariable("name") String name) {
        return "Hello World, "+name+ " !";
    }

    @PostMapping(path = "/goodbye")
    public String goodbye(@RequestBody Person p){
        return "Goodbye, "+ p.getName() + "!";
    }


    @GetMapping("/getperson")
    public Person getPerson(){
        Person p = new Person();
        p.setName("Sital");
        return p;
    }


    // response automatically injected
    @GetMapping("/statustest")
    public void statusTest(HttpServletResponse response){

        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @PostMapping("/test/{name}")
    public String test(@PathVariable  String name,
                       @RequestHeader String a,
                       @RequestHeader String b,
                       @RequestBody String body){

        return name + a + b + body;
    }

    // Request Headers in a map
    @GetMapping(path = "/all")
    public Map<String,String> all(@RequestHeader Map<String,String> map,
                                  HttpServletResponse  response){
        response.addHeader("all","good");
        return map;
    }


    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file(){
        byte[] file = new byte[100];
        return file;
    }

}
