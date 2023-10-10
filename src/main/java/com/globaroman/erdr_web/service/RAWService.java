package com.globaroman.erdr_web.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service

public class RAWService {

    public List<String> readInformationFromFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void writeInformationToFile(String path, List<String> list) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY HH.mm");
        File file = new File(path);
        int count = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            for (String s : list) {
                writer.println(s);
                count++;
            }
            //TODO will do this as a separate method for show information
            //messageDisplayer.showMessage("Записано в файл " + Paths.get(path).getFileName() + " " + count + " рядків\n" + " | " + sdf.format(date) + " |");
//            Desktop.getDesktop().open(new File(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



