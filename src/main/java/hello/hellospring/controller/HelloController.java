package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController{
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "양효빈의 페이지에 오신 것을 환영합니다!!");
        return "hello";
    }
    
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}