package com.globaroman.erdr_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ErdrWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErdrWebApplication.class, args);
        openChrome("http://localhost:8088/main");
    }

    private static void openChrome(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        String chromePath = "";

        chromePath = "\"C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe\"";

        try {
            if (!chromePath.isEmpty()) {

                Runtime.getRuntime().exec(new String[]{chromePath, url});
            } else {

                System.out.println("Браузер Chrome не найден на данной платформе.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
