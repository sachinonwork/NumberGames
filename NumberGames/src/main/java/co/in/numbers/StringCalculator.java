package co.in.numbers;

import org.apache.commons.lang3.StringUtils;

import java.util.StringTokenizer;

public class StringCalculator {

    public int add(String param) {
        if (StringUtils.isBlank(param)) {
            return 0;
        }
        int totalOfAll = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(param, ",");
        while (stringTokenizer.hasMoreTokens()) {
            totalOfAll += Integer.valueOf(stringTokenizer.nextToken());
        }
        return totalOfAll;
    }
}
