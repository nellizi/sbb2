package com.ll.exam.sbb2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Controller
public class MainController {
    @RequestMapping("/sbb")
    public void index(){
        System.out.println("index");
    }
}
