package com.example.model.Controller;

import com.example.model.bo.User;
import com.example.model.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        User user1 = loginService.LoginVerification(user);
        if(user1 != null){
            System.out.println(user1.getName());
            System.out.println(user1.getPassword());
            return "true";
        }else{
            System.out.println("--------------------------------");
            return "用户账户或者密码错误，请重新输入！";
        }
    }
}
