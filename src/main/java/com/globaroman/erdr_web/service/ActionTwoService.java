package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionTwoService extends CompareTwoLists{
    private final RAWService rawService;
    private final StorageInformation storage;

    public void compareTwoLists() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        storage.setListTwo(rawService.readInformationFromFile(PathToFile.LIST_TWO));
        super.compareTxt(storage);
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());

    }

}
