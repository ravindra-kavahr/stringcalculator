package com.calculator.stringcalculator;


import com.calculator.stringcalculator.service.StringCalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorServiceTest {

    private final StringCalculatorService calculatorService = new StringCalculatorService();

    @Test
    public void testEmptyString() {
        assertEquals(0, calculatorService.add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculatorService.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(6, calculatorService.add("1,5"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(6, calculatorService.add("1,2,3"));
    }

    @Test
    public void testNewLinesBetweenNumbers() {
        assertEquals(6, calculatorService.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculatorService.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.add("1,-2,3,-4");
        });
        assertEquals("Negative numbers not allowed: -2,-4", exception.getMessage());
    }

    @Test
    public void testNegativeNumbersMultiple() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.add("1,-2,3,-4,-5");
        });
        assertEquals("Negative numbers not allowed: -2,-4,-5", exception.getMessage());
    }
}
