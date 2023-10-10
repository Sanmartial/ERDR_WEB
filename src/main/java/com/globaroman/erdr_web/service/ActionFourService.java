package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionFourService extends SingleFormat {
    private final RAWService rawService;
    private final StorageInformation storage;

    public void prepareListAsShape() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        bringToSingleFormat(storage);
        storage.setListResult(storage.getListOne().stream().map(this::shapeString).toList());
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());
    }

    public String shapeString(String s) {
        if (s.contains("120")) {
            return s + "000";
        } else return "null";
    }
}
