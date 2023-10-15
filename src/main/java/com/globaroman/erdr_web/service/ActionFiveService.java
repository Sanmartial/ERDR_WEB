package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.service.RAWService;
import com.globaroman.erdr_web.view.ArticlesCriminalCode;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ActionFiveService {
    private final RAWService rawService;
    private final StorageInformation storage;



    public void prepareListNumberToSimpleShapeForGU() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        storage.setListResult(storage.getListOne().stream().map(this::processing).map(e -> compareArr(e, ArticlesCriminalCode.ARTICLE_GU) ? "інші" : e).toList());
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());
    }
    public void prepareListNumberToSimpleShapeForDPD() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        storage.setListResult(storage.getListOne().stream().map(this::processing).map(e -> compareArr(e, ArticlesCriminalCode.ARTICLE_DPD) ? "інші" : e).toList());
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());
    }

    private String processing(String s) {
        String liner = "";
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            liner = matcher.group();
        }
        return liner;
    }

    private boolean compareArr(String s, String[] arrS) {
        return Arrays.stream(arrS).noneMatch(s::equals);
    }


}
