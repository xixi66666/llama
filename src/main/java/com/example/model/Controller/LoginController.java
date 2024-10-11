package com.example.model.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.model.bo.User;
import com.example.model.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author YangChenxi
 * @CreateTime 2024-09-16
 */

@Controller
public class LoginController {

    @Autowired
    loginService loginService;

    @GetMapping(value = {"/"})
    public String loginPage() {
        return "login.html";
    }

    @GetMapping(value = {"/aa"})
    public String test() {
        return "/111.html";
    }

    @RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(@RequestBody User user,HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();

        User user1 = loginService.LoginVerification(user);
        if(user1 != null) {
            jsonObject.put("Status","true");
            HttpSession session = request.getSession();
            session.setAttribute("user", user1);
            return jsonObject.toJSONString();
        }else{
            jsonObject.put("Status","用户名或密码不正确，请重试！");
            return jsonObject.toJSONString();
        }
    }
}
