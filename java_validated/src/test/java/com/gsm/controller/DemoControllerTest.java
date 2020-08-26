package com.gsm.controller;

import cn.hutool.http.HttpRequest;
import com.gsm.JavaValidatedApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaValidatedApplication.class)
public class DemoControllerTest {
    @Autowired
    private DemoController demoController;

    @Test
    public void insertDemo() {
        String user = "{\n" +
                "  \"name\": \"wjq\",\n" +
                "  \"nickName\": \" \",\n" +
                "  \"pwd\": \"123\",\n" +
                "  \"nil\": \"null\",\n" +
                "  \"blank\": \" \",\n" +
                "  \"email\": \"939949244@qq.com\",\n" +
                "  \"flag\": false\n" +
                "}";

        String url = "http://127.0.0.1:10110/demo/insert";
        String result = HttpRequest.post(url)
                .body(user)
                .execute().body();
        System.out.println(result);
    }
}