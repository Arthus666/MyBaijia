package com.dream.mybaijia.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/login")
    public String adminLogin() {
        return "login";
    }

}
