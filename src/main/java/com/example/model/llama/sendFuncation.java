package com.example.model.llama;


import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class sendFuncation {
    public String sendFuncation(String text) throws IOException {
        String url = "http://localhost:11434/api/chat";//请求地址

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS) // 设置连接超时时间
                .writeTimeout(60, TimeUnit.SECONDS) // 设置写入超时时间
                .readTimeout(60, TimeUnit.SECONDS) // 设置读取超时时间
                .build();

        // 定义请求体的媒体类型为JSON
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        String json = "{\n" +
                "\"model\": \"llama3.1\"," +
                "\"messages\": [{\"role\": \"user\", \"content\": \"" + text + "\"}]," +
                "\"stream\": " + false + "}";
        RequestBody body = RequestBody.create(JSON, json);

        //发送POST请求并获取响应：
        Request request = new Request.Builder().url(url)
                .header("Authorization", "Bearer " + "apiKey")
                .header("Content-Type", "application/json") // 显式设置Content-Type头
                .post(body) // 使用POST方法并传递请求体
                .build();
        // 发送请求并获取响应
        Response response = client.newCall(request).execute();
        String result = response.body().string();

        JSONObject returnJsonObject = new JSONObject(result);
        JSONObject messages = returnJsonObject.getJSONObject("message");
        // 提取 content 的值
        String content = messages.getString("content").replace("“", "").replace("\"", "").replace("\r", "").replace("\n", "");
        // 输出 content 的值
        System.out.println("回答的: " + content);
        return content;
    }
}
