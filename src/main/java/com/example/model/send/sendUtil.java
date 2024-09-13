package com.example.model.send;

import com.example.model.llama.sendFuncation;

import java.io.IOException;

public class sendUtil {
    public static void main(String[] args) throws IOException {
        sendFuncation sendFuc = new sendFuncation();
        String resultText = sendFuc.sendFuncation("自我介绍下");
        System.out.println(resultText);
    }
}
