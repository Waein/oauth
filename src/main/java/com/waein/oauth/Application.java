package com.waein.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: Application, v 0.1 WEB SERVER 启动器
 * @CreateDate 2018/11/19
 * @CreateTime 09:08
 * @GitHub https://github.com/Waein
 * ===================================
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println("==========  SERVER START  ==========");
    }

}
