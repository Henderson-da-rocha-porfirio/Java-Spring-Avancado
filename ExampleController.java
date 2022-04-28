package com.tuyo.tuyofood;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 /*@Controller também transforma esta classe num Bean. Porque a classe Controller também recebe um @Component*/
@Controller                            
public class ExampleController {

    @GetMapping("/hello")               
    @ResponseBody                       
    public String hello() {
        return "Olá!";                
    }

}
