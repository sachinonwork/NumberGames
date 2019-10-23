package co.in.numbers;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalculator {

    private String[] stringToCheck = {StringUtils.CR, StringUtils.LF, ";", ":"};

    public int add(String param) throws Exception {
        if (StringUtils.isBlank(param)) {
            return 0;
        }
        List<Integer> errorList = new ArrayList<Integer>();
        int totalOfAll = 0;
        StringTokenizer paramStringToTotal = new StringTokenizer(param, ",");
        while (paramStringToTotal.hasMoreTokens()) {
            String numberToAdd = replaceStringInListIfAny(paramStringToTotal);
            int number = Integer.valueOf(StringUtils.trim(numberToAdd));
            if(number < 0) {
                errorList.add(number);
            }
            if(!CollectionUtils.isEmpty(errorList)) {
                throw new Exception("Number not allowed: ".concat(StringUtils.join(errorList, ",")));
            }
            totalOfAll += number;
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
