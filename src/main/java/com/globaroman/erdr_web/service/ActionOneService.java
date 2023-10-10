package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.view.OpenFileFromOS;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActionOneService extends CompareTwoLists {
    private final RAWService rawService;
    private final StorageInformation storage;

    public void compareTwoLists() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        storage.setListTwo(rawService.readInformationFromFile(PathToFile.LIST_TWO));
        compare(storage);
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());

    }


}
