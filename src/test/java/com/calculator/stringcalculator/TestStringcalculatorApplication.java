package com.calculator.stringcalculator;

import org.springframework.boot.SpringApplication;

public class TestStringcalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.from(StringcalculatorApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
