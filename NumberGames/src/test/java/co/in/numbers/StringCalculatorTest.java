package co.in.numbers;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void checkForBlankStringAddGives0() {
        assertTrue(0 == stringCalculator.add(""));
        assertTrue(0 == stringCalculator.add("  "));
    }

    @Test
    public void shouldGiveSumOfAllNumberInList() {
        assertTrue(18 == stringCalculator.add("2,1,12,1,2"));
        assertTrue(152 == stringCalculator.add("13,58,23,1,45,12"));
    }

    @Test
    public void shouldFailForIncorrectSumOfNumber() {
        assertTrue(12 != stringCalculator.add("2,1,12,1,2"));
    }

    @Test
    public void characterReplacedBeforeSum() {
        assertTrue(12 != stringCalculator.add("2,\r1,12\n,1,2"));
    }
}
