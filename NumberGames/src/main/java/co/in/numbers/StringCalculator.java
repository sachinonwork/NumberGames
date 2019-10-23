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
        StringTokenizer stringTokenizer = new StringTokenizer(param, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String numberToAdd = stringTokenizer.nextToken();
            for(String checkValue : stringToCheck) {
                if(StringUtils.containsAny(numberToAdd, checkValue)) {
                    numberToAdd = numberToAdd.replaceAll(checkValue, "");
                }
            }
            totalOfAll += Integer.valueOf(numberToAdd);
        }
        return totalOfAll;
    }
}
