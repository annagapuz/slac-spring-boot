package com.gaps.sample.boot.controller;

import com.gaps.sample.boot.SampleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class SampleController {

//    @RequestMapping(method = RequestMethod.GET, value = "/hello")
//    public SampleResponse hello() {
//        return new SampleResponse();
//    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public SampleResponse hello(Principal principal, @RequestParam(value = "name", defaultValue = "World") String name) {
        SampleResponse response = new SampleResponse();
        response.setMessage("Hello " + name + ", you were submitted by " + principal.getName());
        return response;
    }

    @PreAuthorize("hasRole('FOO')")
    @GetMapping(value = "/name/{name}")
    public SampleResponse name(Authentication authentication, @PathVariable String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("No name was provided");
        }
        SampleResponse response = new SampleResponse();
        response.setMessage("You are " + name + ", you were submitted by " + authentication.getName());
        return response;
    }

//    @ExceptionHandler
//    public ResponseEntity<SampleResponse> handle(IllegalArgumentException ex) {
//        SampleResponse response = new SampleResponse();
//        response.setMessage(ex.getMessage());
//        response.setCount(HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

}
