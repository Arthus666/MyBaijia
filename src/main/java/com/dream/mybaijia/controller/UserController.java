package com.dream.mybaijia.controller;


import com.alibaba.fastjson.JSONObject;
import com.dream.mybaijia.entity.Article;
import com.dream.mybaijia.entity.JsonResult;
import com.dream.mybaijia.entity.User;
import com.dream.mybaijia.service.impl.UserServiceImpl;
import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import net.sf.jsqlparser.expression.JsonAggregateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public JsonResult<String> userLogin(@RequestBody String jsonStr, HttpSession session) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        User user = userService.queryUserByUsername(username);

        if (user == null) {
            return new JsonResult<>("0");
        } else if (password.equals(user.getPassword())) {
            session.setAttribute("id", user.getId());
            return new JsonResult<>("1");
        } else {
            return new JsonResult<>("0");
        }

    }

    @RequestMapping("/logon")
    public JsonResult<String> userLogon(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String confirm = jsonObject.getString("confirm");
        String born = jsonObject.getString("born");
        String email = jsonObject.getString("email");

        if (password.equals(confirm) == false) {
            return new JsonResult<>("-1");
        } else if (userService.queryUserByUsername(username) != null) {
            return new JsonResult<>("0");
        } else {
            userService.save(new User(0, username, password, email, born));
            return new JsonResult<>("1");
        }

    }

    @RequestMapping("/getInfo")
    public JsonResult<String> getUserInfo(HttpSession session) {
        if (session.getAttribute("id") == null) {
            return new JsonResult<>();
        } else {
            User user = userService.getById(session.getAttribute("id").toString());
            return new JsonResult<>(user.getUsername());
        }

    }

    @RequestMapping("/getUsers")
    public JsonResult<List<User>> getUsers(HttpSession session) {
        return new JsonResult<>(userService.list());
    }

    @RequestMapping("/addUser")
    public JsonResult<String> addUsers(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String email = jsonObject.getString("email");
        String born = jsonObject.getString("born");

        userService.save(new User(0, username, password, email, born));

        return new JsonResult<>("1");
    }

    @RequestMapping("/deleteUser")
    public JsonResult<String> deleteUser(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String id = jsonObject.getString("id");

        userService.removeById(id);

        return new JsonResult<>("1");
    }

    @RequestMapping("/updateUser")
    public JsonResult<String> updateUser(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String userId = jsonObject.getString("id");
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String email = jsonObject.getString("email");
        String born = jsonObject.getString("born");

        int id = Integer.valueOf(userId);

        userService.updateById(new User(id, username, password, email, born));

        return new JsonResult<>("1");
    }

}
