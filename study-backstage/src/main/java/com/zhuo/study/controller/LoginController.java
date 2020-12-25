package com.zhuo.study.controller;

import com.zhuo.study.pojo.User;
import com.zhuo.study.result.Result;
import com.zhuo.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //同源策略（Same origin policy）:域名、协议、端口有一个不同就不是同源，三者均相同，这两个网站才是同源
    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user){
            return new Result(400);
        } else {
            return new Result(200);
        }

    }
}
