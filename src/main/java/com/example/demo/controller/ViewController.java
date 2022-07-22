package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

@Controller
@RequestMapping("/")
public class ViewController {

    public String landingPage() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "judul", required = false) String judul, Model model)
            throws JsonMappingException, JsonProcessingException {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + judul;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> books = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new JsonMapper();
        JsonNode root = mapper.readTree(books.getBody());
        Object book = mapper.convertValue(root.get("items"), Object.class);
        model.addAttribute("books", book);
        System.out.println(book.getClass());
        return "index";
        // return root.get("items");
    }

}
