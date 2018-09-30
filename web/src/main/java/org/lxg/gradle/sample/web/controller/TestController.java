package org.lxg.gradle.sample.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 1:27 PM
 * @DES:
 * @version: v1.0
 */

@RequestMapping("/test")
@Controller
public class TestController {

    @RequestMapping("index")
    public String testIndex(){
        return "testIndex";
    }
}
