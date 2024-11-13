package com.discover.deposit.discover_demo_1.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class ValidationController {

    @GetMapping("/validatePathVariable/{id}")
    ResponseEntity<String> validatePathVariable(@PathVariable("id") @Min(5) int id) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameterWithMin")
    ResponseEntity<String> validateRequestParameterWithMin(@RequestParam("id") @Min(0) int id) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameterWithMax")
    ResponseEntity<String> validateRequestParameterWithMax(@RequestParam("id") @Max(5) int id) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameterWithEmailId")
    ResponseEntity<String> validateRequestParameterWithEmailId( @RequestParam(name = "emailId") @Email String emailId) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameterWithPositive")
    ResponseEntity<String> validateRequestParameterWithPositive(@Positive @RequestParam(name = "id")  int id) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameterWithNegativeOrZero")
    ResponseEntity<String> validateRequestParameterWithNegativeOrZero(@NegativeOrZero @RequestParam(name = "id")  int id) {
        return ResponseEntity.ok("valid");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    String handleConstraintViolationException(ConstraintViolationException e) {
        return "Given input is not valid due to validation error: " + e.getMessage();
    }

}
