package lk.ijse.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")

public class HelloController {
    public HelloController(){
        System.out.println("HelloController Constructor");
    }
    @GetMapping("index")
    public String index(){
        return "index";
    }
    @GetMapping
    public String hello(){
        return "hello";
        }
}
