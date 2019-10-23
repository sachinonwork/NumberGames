package co.in.numbers;

import org.apache.commons.lang3.StringUtils;

import java.util.StringTokenizer;

public class StringCalculator {

    private String[] stringToCheck = {StringUtils.CR, StringUtils.LF, ";", ":"};

    public int add(String param) {
        if (StringUtils.isBlank(param)) {
            return 0;
        }
        int totalOfAll = 0;
        StringTokenizer paramStringToTotal = new StringTokenizer(param, ",");
        while (paramStringToTotal.hasMoreTokens()) {
            String numberToAdd = replaceStringInListIfAny(paramStringToTotal);
            totalOfAll += Integer.valueOf(numberToAdd);
        }
        return totalOfAll;
    }

    private String replaceStringInListIfAny(StringTokenizer stringToLookUp) {
        String numberToAdd = stringToLookUp.nextToken();
        for(String checkValue : stringToCheck) {
            if(StringUtils.containsAny(numberToAdd, checkValue)) {
                numberToAdd = numberToAdd.replaceAll(checkValue, "");
            }
        }
        return numberToAdd;
    }
}
