package com.globaroman.erdr_web.service;


import com.globaroman.erdr_web.model.Policeman;
import com.globaroman.erdr_web.model.StorageInformation;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CompareListPoliceman {
    public void compareEmployees(StorageInformation storageMemory) {
        List<Policeman> list = checkEmployees(storageMemory.getListPolicemanOne(), storageMemory.getListPolicemanTwo());
        list.sort(Comparator.comparingInt(Policeman::getID));
        storageMemory.setListResult(forWriteToList(list));
    }

    private List<String> forWriteToList(List<Policeman> listResult2) {
        return listResult2.stream()
                .map(policeman -> policeman.getUnit() + "\t" + policeman.getRank() + " " + policeman.getSurname() + " " + policeman.getFirstName() + " " + policeman.getPatronymic() +
                " " + policeman.getPosition() + policeman.getChangeless())
                .toList();
    }

    private List<Policeman> checkEmployees(List<Policeman> listPolicePresent, List<Policeman> listPolicePrevious) {

        List<Policeman> listResult2 = listPolicePresent.stream()
                .filter(x -> getCountLoop(x, listPolicePrevious) == listPolicePrevious.size())
                .map(p -> checkChanges(p, listPolicePrevious))
                .collect(Collectors.toList());

        listResult2.addAll(listPolicePrevious.stream()
                .filter(x -> getCountLoopSurname(x.getSurname(), listPolicePresent) == listPolicePresent.size())
                .peek(p -> p.setChangeless("\tВИБУВ")).toList());

        return listResult2;
    }

    private int getCountLoop(Policeman policeman, List<Policeman> listPolicePrevious) {
        return (int) listPolicePrevious.stream().filter(x -> !x.equals(policeman)).count();
    }

    private int getCountLoopSurname(String policeman, List<Policeman> listPolicePrevious) {
        return (int) listPolicePrevious.stream().filter(x -> !x.getSurname().equals(policeman)).count();
    }

    private Policeman checkChanges(Policeman policeman, List<Policeman> listPolicePrevious) {
        int countRank = (int) listPolicePrevious.stream()
                .filter(policePr -> !(policeman.getSurname().equals(policePr.getSurname()) && policeman.getRank().equals(policePr.getRank())))
                .count();
        int countFN = (int) listPolicePrevious.stream()
                .filter(policePr -> !(policeman.getSurname().equals(policePr.getSurname()) && policeman.getFirstName().equals(policePr.getFirstName())))
                .count();
        int countPos = (int) listPolicePrevious.stream()
                .filter(policePr -> !(policeman.getSurname().equals(policePr.getSurname()) && policeman.getPosition().equals(policePr.getPosition())))
                .count();

        if (countPos == listPolicePrevious.size() && countFN != listPolicePrevious.size() && countRank != listPolicePrevious.size())
            policeman.setChangeless("\tзмінилась посада");
        if (countFN == listPolicePrevious.size() && countPos == listPolicePrevious.size() && countRank == listPolicePrevious.size())
            policeman.setChangeless("\tНОВИЙ");
        if (countFN != listPolicePrevious.size() && countPos != listPolicePrevious.size() && countRank == listPolicePrevious.size())
            policeman.setChangeless("\tзмінилось звання");
        if (countFN != listPolicePrevious.size() && countPos == listPolicePrevious.size() && countRank == listPolicePrevious.size())
            policeman.setChangeless("\tзмінилися звання та посада");
        return policeman;
    }
}

