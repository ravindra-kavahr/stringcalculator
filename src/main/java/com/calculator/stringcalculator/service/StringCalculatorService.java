package com.calculator.stringcalculator.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StringCalculatorService {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        // Check for custom delimiter format
        if (numbers.startsWith("//")) {
            return handleCustomDelimiter(numbers);
        }


        String[] numberStrings = numbers.split("[,\\n]");
        List<Integer> numberList = new ArrayList<>();
        for (String number : numberStrings) {
            if (!number.isEmpty()) {
                numberList.add(Integer.parseInt(number.trim()));
            }
        }


        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for (int number : numberList) {
            if (number < 0) {
                negativeNumbers.add(number);
            } else {
                sum += number;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(",", negativeNumbers.toString()));
        }

        return sum;
    }

    private int handleCustomDelimiter(String numbers) {

        int delimiterIndex = numbers.indexOf("\n");
        String delimiterLine = numbers.substring(2, delimiterIndex);
        String numbersPart = numbers.substring(delimiterIndex + 1);


        String delimiter = delimiterLine.replaceAll("[^a-zA-Z0-9]", "");
        String[] numberStrings = numbersPart.split(delimiter);
        List<Integer> numberList = new ArrayList<>();
        for (String number : numberStrings) {
            if (!number.isEmpty()) {
                numberList.add(Integer.parseInt(number.trim()));
            }
        }


        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for (int number : numberList) {
            if (number < 0) {
                negativeNumbers.add(number);
            } else {
                sum += number;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(",", negativeNumbers.toString()));
        }

        return sum;
    }
}
