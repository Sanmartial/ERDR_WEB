package com.globaroman.erdr_web.service;

import com.globaroman.erdr_web.IntegrationTestBase;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RAWServiceTest extends IntegrationTestBase {

    @Autowired
    RAWService rawService = new RAWService();

    final String pathOne = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathResult = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";

    @Test
    void readInformationFromFile() {
        List<String> list = rawService.readInformationFromFile(pathOne);

        MatcherAssert.assertThat(list, IsCollectionWithSize.hasSize(list.size()));
    }

    @Test
    void writeInformationToFile() {
        List<String> listIn = rawService.readInformationFromFile(pathOne);
        rawService.writeInformationToFile(pathResult, listIn);
        List<String> listOut = rawService.readInformationFromFile(pathResult);
        assertEquals(listIn.size(), listOut.size());
    }
}