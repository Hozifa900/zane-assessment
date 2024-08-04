package com.assessment.assessment.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {
        @GetMapping("")
        public ResponseEntity<?> getPlans(@RequestHeader("Authorization") String token) {
                Map<String, Object> response = new HashMap<>();
                System.out.println(token);
                if (!token.equals(
                                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjkzNDAxODUyLCJleHAiOjE2OTQwMDY2NTJ9.pIj3j0Sw3RmF-f4_YnfiwG8uMkMY-U0OSMG9ml27E0s")) {
                        response.put(
                                        "success", false);
                        response.put(
                                        "message", "Invalid token");
                        response.put(
                                        "data", null);
                        response.put(
                                        "status", HttpStatus.UNAUTHORIZED.value());
                        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
                }
                List<Object> data = new ArrayList<>();
                Map<String, Object> plan1 = new HashMap<>();
                plan1.put(
                                "id", "1");
                plan1.put("title", "Packaging Design");
                plan1.put("score", 40);
                plan1.put("outOf", 48);
                data.add(plan1);
                Map<String, Object> plan2 = new HashMap<>();
                plan2.put(
                                "id", "2");
                plan2.put("title", "Product Design");
                plan2.put("score", 6);
                plan2.put("outOf", 24);
                data.add(plan2);

                Map<String, Object> plan3 = new HashMap<>();
                plan3.put(
                                "id", "3");
                plan3.put("title", "Software Design");
                plan3.put("score", 89);
                plan3.put("outOf", 100);
                data.add(plan3);

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

        @GetMapping("/s")
        public String getPlan() {
                return "Hello";
        }

}
