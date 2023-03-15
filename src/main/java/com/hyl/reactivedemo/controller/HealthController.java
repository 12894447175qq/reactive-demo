package com.hyl.reactivedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> </p>
 *
 * @Author hyl.c
 * @Date {2023/3/15}
 */
@RequestMapping()
@RestController
public class HealthController {

    @GetMapping("/hs")
    public String hs() {
        return "OK";
    }
}
