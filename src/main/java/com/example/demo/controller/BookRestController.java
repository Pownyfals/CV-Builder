package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

@RestController
public class BookRestController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping(value = "/searchRest")
    // @JsonProperty("data")
    public JsonNode searchBook() throws JsonMappingException, JsonProcessingException {
        String url = "https://www.googleapis.com/books/v1/volumes?q=flower";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> books = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new JsonMapper();
        JsonNode book = mapper.readTree(books.getBody());
        System.out.println(book.get("items"));
        return book.get("items");
    }
}
