package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ViewController {

    public String landingPage() {
        return "index";
    }

    @GetMapping("https://www.googleapis.com/books/v1/volumes?q={judul}")
    public String search(@PathVariable String judul)  {
        return "index";
    }

}


