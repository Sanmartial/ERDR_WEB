package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;
import com.globaroman.erdr_web.service.RAWService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActionEightService {
    private final RAWService rawService;
    private final StorageInformation storage;

    public void compareTwoListsEmployees() {
    }
}
