package com.globaroman.erdr_web.model;

import lombok.Getter;

import java.util.Objects;
@Getter
public class Policeman {
    private final int ID;
    private final String rank; //звание
    private final String surname; // фамилия
    private final String firstName; // имя
    private final String patronymic; //отчество
    private final String tokenID; // номер жетона
    private final String Position; // должность
    private final String unit; // подразделение короткий номер
    private String changeless; //фиксируем изменение
    public Policeman(int ID, String rank, String surname, String firstName, String shortName, String patronymic, String tokenID, String position, String unit) {
        this.ID = ID;
        this.rank = rank;
        this.surname = surname;
        this.firstName = firstName;
        // инициалы
        this.patronymic = patronymic;
        this.tokenID = tokenID;
        this.Position = position;
        this.unit = unit;
    }
    @Override
    public String toString() {
        return rank + " " + surname + " " + firstName + " " + patronymic + " " + tokenID + " " + Position + " " + unit + " " + changeless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policeman policeman = (Policeman) o;
        return rank.equals(policeman.rank) && surname.equals(policeman.surname) && Position.equals(policeman.Position);
    }
    @Override
    public int hashCode() {
        return Objects.hash(rank, surname, Position);
    }

    public void setChangeless(String changeless) {
        this.changeless = changeless;
    }

}
