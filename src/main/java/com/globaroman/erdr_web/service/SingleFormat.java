package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.model.StorageInformation;

import java.util.List;

public abstract class SingleFormat {
    public void bringToSingleFormat(StorageInformation storage) {
        storage.setListOne(storage.getListOne().stream().map(this::stringErdr).toList());
    }

    private String stringErdr(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (sb.indexOf("№") >= 0) {
            sb.deleteCharAt(sb.indexOf("№"));
        }
        while ((sb.indexOf(" ")) >= 0) {
            sb.deleteCharAt(sb.indexOf(" "));
        }
        if (sb.indexOf("-") >= 0) {
            sb.deleteCharAt(sb.indexOf("-"));
        }
        System.out.println(sb.substring(0, 17));
        return sb.substring(0, 17);

    }


    public abstract String shapeString(String s);
}
