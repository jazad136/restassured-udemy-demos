package com.studentapp.allureexamples.app;

import io.qameta.allure.Step;

/**
 *
 * @author JonathanSaddler
 */
public class CalculatorSteps {
    @Step("Adding 2 numbers: {0} & {1}")
    public double add2Numbers(double n1, double n2) { 
        MySimpleCalculator calculate = new MySimpleCalculator();
        return calculate.add2Num(n1, n2);
    }
}
