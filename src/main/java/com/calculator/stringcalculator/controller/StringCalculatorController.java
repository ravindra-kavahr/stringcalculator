package com.calculator.stringcalculator.controller;

import com.calculator.stringcalculator.service.StringCalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class StringCalculatorController {

    private final StringCalculatorService calculatorService;

    public StringCalculatorController(StringCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public int add(@RequestBody String numbers) {
        return calculatorService.add(numbers);
    }
}


