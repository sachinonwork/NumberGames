package co.in.numbers;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void checkForBlankStringAddGives0() throws Exception {
        assertTrue(0 == stringCalculator.add(""));
        assertTrue(0 == stringCalculator.add("  "));
    }

    @Test
    public void shouldGiveSumOfAllNumberInList() throws Exception {
        assertTrue(18 == stringCalculator.add("2,1,12,1,2"));
        assertTrue(152 == stringCalculator.add("13,58,23,1,45,12"));
    }

    @Test
    public void shouldFailForIncorrectSumOfNumber() throws Exception {
        assertTrue(12 != stringCalculator.add("2,1,12,1,2"));
    }

    @Test
    public void characterReplacedBeforeSum() throws Exception {
        assertTrue(18 == stringCalculator.add("2, \r1,12\n, 1,2"));
    }

    @Test
    public void ignoreNegativeNumbersInParam() {
        try {
            stringCalculator.add("2, -11,12, 1, 2");
        } catch(Exception ex) {
            assertTrue("Number not allowed: -11".equalsIgnoreCase(ex.getMessage()));
        }
    }
}
