package com.example.model.demos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author YangChenxi
 * @CreateTime 2024-09-16
 */

@Controller
public class LoginController {
    @GetMapping(value = {"/"})
    public String loginPage() {
        return "test.html";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
//        if (StringUtils.hasLength(user.getName()) && StringUtils.hasLength(user.getPassword())) {
//            session.setAttribute("loginUser", user);
//            return "redirect:/index.html";
//        } else {
//            model.addAttribute("msg", "账号密码错误");
//            return "111.html";
//        }
        return "true";

    }
}
