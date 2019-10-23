package co.in.numbers;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void checkForBlankStringAddGives0() {
        assertTrue(0 == stringCalculator.add(""));
    }

    @Test
    public void shouldGiveSumOfAllNumberInList() {
        assertTrue(18 == stringCalculator.add("2,1,12,1,2"));
    }
}
