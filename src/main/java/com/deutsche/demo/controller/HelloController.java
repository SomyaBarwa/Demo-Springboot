package com.deutsche.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        LOG.info("hello");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hello world!");
    }

    @GetMapping("hi")
    public ResponseEntity<String> hi() {
        LOG.info("hi");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hi! How're you?");
    }
}
