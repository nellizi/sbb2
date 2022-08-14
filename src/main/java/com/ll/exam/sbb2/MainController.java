package com.ll.exam.sbb2;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.security.PublicKey;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    int i = -1;
    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        System.out.println("index");
        return """
                <h1>안녕하세요</h1>
                <form method="POST" action="/page2">
                <input type="submit" value="page2로 post방식으로 이동" />
                <form>
                """;
    }

    @GetMapping("/page1")
    @ResponseBody
    public String showpage1(){
        return """
                <form method="POST" action="/page2">
                <input type="number" name="age" placeholder="나이">
                <input type="submit" value="page2로 post방식으로 이동" />
                <form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String showPage2(@RequestParam(defaultValue = "0") int age){
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>안녕하세요, POST방식으로 오셨군요.</h1>
                """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public String plus(int a, int b){
        return a + b +"";
    }
    @GetMapping("/minus")
    @ResponseBody
    public String minus(int a, int b){
        return a - b +"";
    }
    @GetMapping("/increase")
    @ResponseBody
    public int increase(){
        i++;
        return i;
    }

    @GetMapping("/gugudan")
    @ResponseBody
    public String showGugudan(Integer dan, Integer limit){
        if(dan == null){
            dan =  9;
        }
        if(limit == null){
            limit =  9;
        }
        Integer finalDan = dan;
        return IntStream.rangeClosed(1,limit)
                .mapToObj(i ->  "%d * %d = %d".formatted(finalDan, i,finalDan*i))
                .collect(Collectors.joining("<br>"));


    }
}
