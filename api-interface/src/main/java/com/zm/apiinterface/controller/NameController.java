package com.zm.apiinterface.controller;


import com.zm.apiclientsdk.model.User;
import com.zm.apiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称API
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("")
    public String getNameByGet(String name, HttpServletRequest request) {

        return "GET 你的名字是" + name;
    }

    @PostMapping("")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey= request.getHeader("accessKey");
        String nonce=request.getHeader("nonce");
        String timestamp=request.getHeader("timestamp");
        String sign=request.getHeader("sign");
        String body=request.getHeader("body");
        //todo 去数据库查是否已分配给用户
        if(!accessKey.equals("")){
            throw new RuntimeException("无权限");
        }
        if(Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }
        //时间和当前时间不能超过五分钟
        if(Math.abs(System.currentTimeMillis()/1000 - Long.parseLong(timestamp)) > 60*5){
            throw new RuntimeException("无权限");
        }
        //todo 去数据库查出用户的密钥
        String serverSign = SignUtils.genSign(body, "");
        if(!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }
        return "POST 用户名字是" + user.getUsername();
    }
}
