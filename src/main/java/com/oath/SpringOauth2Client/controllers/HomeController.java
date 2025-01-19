package com.oath.SpringOauth2Client.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/helloSecured")
    public String homeSecured() {
        return "Hello World Secured!";
    }
}
