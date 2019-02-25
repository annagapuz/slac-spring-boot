package com.gaps.sample.boot.controller;

import com.gaps.sample.boot.SampleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

//    @RequestMapping(method = RequestMethod.GET, value = "/hello")
//    public SampleResponse hello() {
//        return new SampleResponse();
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public SampleResponse hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        SampleResponse response = new SampleResponse();
        response.setMessage("Hello " + name);
        return response;
    }

    @GetMapping(value = "/name/{name}")
    public SampleResponse name(@PathVariable String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("No name was provided");
        }
        SampleResponse response = new SampleResponse();
        response.setMessage("You are " + name);
        return response;
    }

//    @ExceptionHandler
//    public ResponseEntity<SampleResponse> handle(IllegalArgumentException ex) {
//        SampleResponse response = new SampleResponse();
//        response.setMessage(ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

}
