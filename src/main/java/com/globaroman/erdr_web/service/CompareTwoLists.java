package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;

import java.util.ArrayList;
import java.util.List;

public class CompareTwoLists {
    void compare(StorageInformation storage) {

        List<String> listR = new ArrayList<>();
        for (String StringFromListOne : storage.getListOne()) {
            int count = 0;
            for (String StringFromListOTwo : storage.getListTwo()) {
                if (equivalentData(StringFromListOne, StringFromListOTwo)) {
                    listR.add(StringFromListOne + " " + StringFromListOTwo);
                }
                count = (int) storage.getListTwo().stream().filter(x -> !x.equals(StringFromListOne)).count();

            }
            if (count == storage.getListTwo().size()) {
                listR.add("--");
            }
        }
        storage.setListResult(listR);
    }

    private boolean equivalentData(String s1, String s2) {
        return s2.equals(s1);

    }
    public void compareTxt(StorageInformation storage) {

        List<String> listR = new ArrayList<>();
        for (int i = 0; i < storage.getListOne().size(); i++) {
            int count = 0;
            for (int j = 0; j < storage.getListTwo().size(); j++) {
                if (storage.getListOne().get(i).equals(storage.getListTwo().get(j))) {
                    listR.add("OK");
                } else
                    count++;
            }
            if (count == storage.getListTwo().size()) {
                listR.add("--");
            }
        }
        storage.setListResult(listR);
    }
}

