package com.ll.exam.sbb2;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    int i = -1;

    @RequestMapping("/sbb")
    @ResponseBody
    public String index() {
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
    public String showpage1() {
        return """
                <form method="POST" action="/page2">
                <input type="number" name="age" placeholder="나이">
                <input type="submit" value="page2로 post방식으로 이동" />
                <form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String showPage2(@RequestParam(defaultValue = "0") int age) {
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>안녕하세요, POST방식으로 오셨군요.</h1>
                """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public String plus(int a, int b) {
        return a + b + "";
    }

    @GetMapping("/minus")
    @ResponseBody
    public String minus(int a, int b) {
        return a - b + "";
    }

    @GetMapping("/increase")
    @ResponseBody
    public int increase() {
        i++;
        return i;
    }

    @GetMapping("/gugudan")
    @ResponseBody
    public String showGugudan(Integer dan, Integer limit) {
        if (dan == null) {
            dan = 9;
        }
        if (limit == null) {
            limit = 9;
        }
        Integer finalDan = dan;
        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> "%d * %d = %d".formatted(finalDan, i, finalDan * i))
                .collect(Collectors.joining("<br>"));

    }

    @GetMapping("/mbti/{name}")
    @ResponseBody
    public String showMbti(@PathVariable String name) {
        System.out.println("실행중?");
        String mbti = switch (name) {
            case "홍길동" -> "INFP";
            case "홍길순" -> {
                char j = 'j';
                yield "INF" + j;
            }
            case "임꺽정" -> "ISTJ";
            case "이지현" -> "ENFP";
            default -> "CUTE";
        };
        return mbti;
    }


//     return switch(name){
//        case "홍길동" -> "INFP";
//        case "홍길순" -> "ENTJ";
//        case "임꺽정" -> "ISTJ";
//        case "이지현" -> "ENFP";
//        default -> "CUTE";
//    };    이렇게 한 번에 리턴으로 보내기도 가능


    @RequestMapping(value = "/savaSessionAge")
    @ResponseBody
    public String ageSession(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String age = "10";
        session.setAttribute("age", age);
        return age;
    }
    @RequestMapping(value = "/getSessionAge")
    @ResponseBody
    public String ageSession2(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        String age = (String)session.getAttribute("age");
        return "세션에 저장된 값 = " + age;
    }


}
