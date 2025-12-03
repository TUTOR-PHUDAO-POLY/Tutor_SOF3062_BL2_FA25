package com.poly.server.B5_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("public/test")
    public String publicTestAPI() {
        return "Tat ca cac trang deu duoc truy cap";
    }

    @GetMapping("api/admin/test")
    public String adminTestAPI() {
        return "Chi admin duoc truy cap";
    }

    @GetMapping("api/user/test")
    public String userTestAPI() {
        return "Chi user duoc truy cap";
    }

}
