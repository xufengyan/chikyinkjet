package com.zk.chinkjet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/3 15:03
 */
public class controller {

    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost/zkmap/verify/getAccessToken");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true); // 设置可输入
        connection.setDoOutput(true); // 设置该连接是可以输出的
        connection.setRequestMethod("POST"); // 设置请求方式
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("code", "001");
        data.put("name", "测试");

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
        pw.write(objectMapper.writeValueAsString(data));
        pw.flush();
        pw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line = null;
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) { // 读取数据
            result.append(line + "\n");
        }
        connection.disconnect();
    }

}
