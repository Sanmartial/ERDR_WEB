package com.globaroman.erdr_web.service;


import com.globaroman.erdr_web.model.Policeman;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class SeparateStringForPoliceman {

    String RegForName = "(поліції) ([А-ЯІЇЮЄа-яіїює'’]+) ([А-ЯІЇЮЄа-яіїює'’]+) ([А-ЯІЇЮЄа-яіїює'’]+)"; //нужно только указывать номер групы фамилия -2, имя 3, отчество - 4
    private final String RegPosition = "([0-9\\),\\(]+) ([А-яіЇї\\s\\W0-9№]+)";//номер группы 2

    public List<Policeman> getListPoliceman(List<String> list) {

        List<Policeman> listPol = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 60) {
                listPol.add(new Policeman(
                        i + 1,
                        getRank(list.get(i)),
                        getSurname(list.get(i)),
                        getFirstName(list.get(i)),
                        getShortName(list.get(i)),
                        getPatronymic(list.get(i)),
                        getTokenID(list.get(i)),
                        getPosition(list.get(i)),
                        getUnit(list.get(i))));
            }
        }

        return listPol;

    }

    private String separateWithRegExpression(String patternS, String fromList, int numberGroup) {
        String list = null;
        Pattern pattern = Pattern.compile(patternS);
        Matcher matcher = pattern.matcher(fromList);
        while (matcher.find()) {
            list = matcher.group(numberGroup);
        }
        return list;
    }

    private String getRank(String s) {
        String regRank = "[(старший )? А-яі]* поліції";//звание
        return separateWithRegExpression(regRank, s, 0);
    }

    private String getSurname(String s) {
        return separateWithRegExpression(RegForName, s, 2);
    }

    private String getFirstName(String s) {
        return separateWithRegExpression(RegForName, s, 3);
    }

    private String getPatronymic(String s) {
        return separateWithRegExpression(RegForName, s, 4);
    }

    private String getShortName(String fromList) {
        String firstName;
        String patronymic;
        StringBuilder sb = new StringBuilder();
        firstName = separateWithRegExpression(RegForName, fromList, 3);
        patronymic = separateWithRegExpression(RegForName, fromList, 4);
        firstName = separateInitials(firstName);
        patronymic = separateInitials(patronymic);
        sb.append(firstName).append(" ").append(patronymic);
        return sb.substring(0);
    }

    private String getTokenID(String s) {
        String regTokenID = "\\d{7}";
        return separateWithRegExpression(regTokenID, s, 0);
    }//номер жетона

    private String getPosition(String s) {
        return separateWithRegExpression(RegPosition, s, 2);
    }

    private String getUnit(String s1) {
        String position = separateWithRegExpression(RegPosition, s1, 2);
        String s = "#";
        StringBuilder sb = new StringBuilder();
        sb.append(position);
        if ((sb.indexOf("командир полку")) >= 0)
            return "КП";
        if ((sb.indexOf("заступник командира полку")) >= 0)
            return "ЗКП";
        if ((sb.indexOf("помічник начальника")) >= 0 || (sb.indexOf("інспектор штабу")) >= 0 || (sb.indexOf("відділення документування")) >= 0)
            return "штаб";
        if ((sb.indexOf("чергової частини")) >= 0)
            return "ЧЧ";
        if ((sb.indexOf("відділення зв’язку")) >= 0)
            return "зв'язок";
        if ((sb.indexOf("відділення кадрового")) >= 0)
            return "кадри";
        if ((sb.indexOf("відділення логістики")) >= 0)
            return "ВЛМТЗ";
        if ((sb.indexOf("тактико")) >= 0)
            return "БСП";
        if ((sb.indexOf("відділення превентивної")) >= 0)
            return "ВПК";
        if ((sb.indexOf("автотранспортної")) >= 0)
            return "АР";
        if ((sb.indexOf("роти № 1")) >= 0)
            return "1";
        if ((sb.indexOf("роти № 2")) >= 0)
            return "2";
        if ((sb.indexOf("роти № 3")) >= 0)
            return "3";
        if ((sb.indexOf("роти № 4")) >= 0)
            return "4";
        if ((sb.indexOf("роти № 5")) >= 0)
            return "5";
        if ((sb.indexOf("швидкого реагування")) >= 0)
            return "РШР";
        return s;
    }

    private String separateInitials(String firstName) {
        StringBuilder sb = new StringBuilder();
        char[] ch = firstName.toCharArray();
        sb.append(ch[0]).append(".");
        return sb.substring(0);
    }


}
