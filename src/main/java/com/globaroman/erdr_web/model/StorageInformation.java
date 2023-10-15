package com.globaroman.erdr_web.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Getter
@Component
public class StorageInformation {
    private List<String> listOne;
    private List<String> listTwo;
    private List<String> listResult;

    private List<Policeman> listPolicemanOne = new ArrayList<>();
    private List<Policeman> listPolicemanTwo = new ArrayList<>();

    public void setListPolicemanOne(List<Policeman> listPolicemanOne) {
        this.listPolicemanOne = listPolicemanOne;
    }

    public void setListPolicemanTwo(List<Policeman> listPolicemanTwo) {
        this.listPolicemanTwo = listPolicemanTwo;
    }

    public void setListResult(List<String> listResult) {
        this.listResult = listResult;
    }

    public void setListOne(List<String> listOne) {
        this.listOne = listOne;
    }

    public void setListTwo(List<String> listTwo) {
        this.listTwo = listTwo;
    }
}
