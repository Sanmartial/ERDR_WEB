package com.globaroman.erdr_web.view;

import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class OpenFileFromOS {
    public void openFile(String path) {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                Process process = Runtime.getRuntime().exec("cmd /c start " + path);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                Process process = Runtime.getRuntime().exec("xdg-open " + path);
            } else {
               throw new UnsupportedOperationException("Unsupported operating system");
            }
        } catch (IOException e) {
            e.printStackTrace();


        }


    }

}

