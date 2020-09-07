package com.gsm.config;

import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JApiConfig {

    public DocsConfig jApiConfig(){
        DocsConfig config = new DocsConfig();
  /*      config.setProjectPath("C:\\Users\\ThinkPad\\Desktop\\wyxjava微服务\\Java_Parent\\java_japi"); // 项目根目录
        config.setProjectName("ProjectName"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("C:\\Users\\ThinkPad\\Desktop\\wyxjava微服务\\Java_Parent\\java_japi"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档*/
        return config;
    }
}
