package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionThreeService extends SingleFormat {
    private final RAWService rawService;
    private final StorageInformation storage;

    public void prepareListAsShape() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        bringToSingleFormat(storage);
        storage.setListResult(storage.getListOne().stream().map(this::shapeString).toList());
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());
    }

    public String shapeString(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        sb.append(s);
        if (s.contains("120")) {
            return sb1.append(sb.substring(0, 1))
                    .append(" ").append(sb.substring(1, 5))
                    .append(" ").append(sb.substring(5, 10))
                    .append("-").append(sb.substring(10, 17))
                    .substring(0);
        } else
            return "null";
    }


}