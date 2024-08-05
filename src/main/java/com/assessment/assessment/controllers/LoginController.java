package com.assessment.assessment.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.assessment.dto.LoginRequestDto;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
        @PostMapping("")
        public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
                Map<String, Object> response = new HashMap<>();
                if (!loginRequest.username().equals("user") || !loginRequest.password().equals("password")) {
                        response.put(
                                        "success", false);
                        response.put(
                                        "message", "Invalid username or password");
                        response.put(
                                        "data", null);
                        response.put(
                                        "status", HttpStatus.UNAUTHORIZED.value());
                        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
                }
                List<String> data = new ArrayList<>();
                data.add(
                                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjkzNDAxODUyLCJleHAiOjE2OTQwMDY2NTJ9.pIj3j0Sw3RmF-f4_YnfiwG8uMkMY-U0OSMG9ml27");

                response.put(
                                "success", true);
                response.put(
                                "message", "Login successful");
                response.put(
                                "data", data);
                response.put(
                                "status", HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
}
