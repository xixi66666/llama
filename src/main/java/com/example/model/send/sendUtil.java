package com.example.model.send;

import com.example.model.llama.sendFuncation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("/haha")
public class sendUtil {
    public static void main(String[] args) throws IOException {
        sendFuncation sendFuc = new sendFuncation();
        String resultText = sendFuc.sendFuncation("自我介绍下");
        System.out.println(resultText);
    }

    @PostMapping("/send")
//@RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }

}
