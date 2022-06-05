package com.dream.mybaijia.controller;

import com.alibaba.fastjson.JSONObject;
import com.dream.mybaijia.entity.Admin;
import com.dream.mybaijia.entity.JsonResult;
import com.dream.mybaijia.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.soap.SAAJResult;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public JsonResult<String> adminLogin(HttpSession session, @RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        Admin admin = adminService.queryAdminByUsername(username);

        if (admin == null || admin.getPassword().equals(password) == false) {
            return new JsonResult<>("0");
        } else {
            session.setAttribute("adminId", admin.getId());
            return new JsonResult<>("1");
        }

    }

    @RequestMapping("/adminInfo")
    @ResponseBody
    public JsonResult<Admin> adminInfo(HttpSession session) {

        Object attribute = session.getAttribute("adminId");

        if (attribute == null) {
            return new JsonResult<>();
        } else {
            Admin admin = adminService.getById(attribute.toString());
            return new JsonResult<>(admin);
        }

    }

    @RequestMapping("/exitLogin")
    @ResponseBody
    public JsonResult<String> exitLogin(HttpSession session) {
        session.removeAttribute("adminId");
        return new JsonResult<>();
    }

}
