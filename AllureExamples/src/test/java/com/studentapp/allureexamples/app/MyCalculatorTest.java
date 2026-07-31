package com.studentapp.allureexamples.app;
import com.studentapp.allureexamples.app.MySimpleCalculator;
import io.qameta.allure.Description;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Calculator to perform mathematical operations")
public class MyCalculatorTest {
    @Test
    @DisplayName("Calculate the sum of two numbers")
    @Description("""
                 This is a test method that will add 2 numbers,
                 This test focuses on the addition of 2 numbers & checks
                 if the result of the calculation is valid
                 """)
    public void tc1() {
        MySimpleCalculator calculate = new MySimpleCalculator();
        calculate.add2Num(3.0,5.0);
        assertThat(calculate.add2Num(3.0, 5.0), equalTo(8.0));
    }
    
    public void tc2(){

        MySimpleCalculator calculator = new MySimpleCalculator();
        assertThat(calculator.sub2Num(5.0,4.0) ,equalTo(1.0));
    }
    
    public void tc3(){

        MySimpleCalculator calculator = new MySimpleCalculator();
        assertThat(calculator.mul2Num(5.0,4.0) ,equalTo(20.0));
    }
    
    public void tc4(){

        MySimpleCalculator calculator = new MySimpleCalculator();
        assertThat(calculator.div2Num(20.0,4.0) ,equalTo(6.0));
    }
    
}
