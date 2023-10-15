package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ActionSixService {
    private final RAWService rawService;
    private final StorageInformation storage;

    public void addingRows(int amountRows) {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        List<String> listResult = new ArrayList<>();
        for (int i = 0; i < storage.getListOne().size(); i++) {
            listResult.add(storage.getListOne().get(i));
            for (int j = 0; j < amountRows; j++) {
                if (j == amountRows - 1) {
                    listResult.add(getChangedString(storage.getListOne().get(i)));

                } else {
                    listResult.add("");
                }
            }
        }
        storage.setListResult(listResult);
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());
        fixAmountRows(amountRows);
    }

    private void fixAmountRows(int amountRows) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(amountRows));
        rawService.writeInformationToFile(PathToFile.AMOUNT_ROWS, list);
    }

    private String getChangedString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'Т') ch[i] = '-';
            if (ch[i] == 'Н') ch[i] = '-';
            if (ch[i] == 'В') ch[i] = '-';
            if (ch[i] == 'T') ch[i] = '-';
            if (ch[i] == 'H') ch[i] = '-';
            if (ch[i] == 'B') ch[i] = '-';
            sb.append(ch[i]);
        }

        return sb.substring(0);
    }
}

