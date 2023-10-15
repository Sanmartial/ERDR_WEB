package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.service.RAWService;
import com.globaroman.erdr_web.view.PathToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionSevenService {
    private final RAWService rawService;
    private final StorageInformation storage;

    public void prepareShapeForAssignment() {
        storage.setListOne(rawService.readInformationFromFile(PathToFile.LIST_ONE));

    }
}
