package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionSevenService {
    private final RAWService rawService;
    private final StorageInformation storage;
    private final SeparateStringForPoliceman separateStringForPoliceman;
    private final CompareListPoliceman comparePoliceman;

    public void prepareShapeForAssignment() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));
        storage.setListTwo(rawService.readInformationFromFile(PathToFile.LIST_TWO));
        storage.setListPolicemanOne(separateStringForPoliceman.getListPoliceman(storage.getListOne()));
        storage.setListPolicemanTwo(separateStringForPoliceman.getListPoliceman(storage.getListTwo()));
        comparePoliceman.compareEmployees(storage);
        rawService.writeInformationToFile(PathToFile.RESULT, storage.getListResult());
    }
}
