package com.studentapp.allureexamples.app;
import com.studentapp.allureexamples.app.MySimpleCalculator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@Epic("All tools for calculation")
@Feature("Calculator to perform mathematical operations")
@DisplayName("Calculator to perform mathematical operations")

public class MyCalculatorTest {
    @Test
    @DisplayName("Calculate the sum of two numbers")
    @Story("Calculate the sum of two numbers")
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
    
    
    @TmsLink("TestLink")
    @DisplayName("Calculate difference of 2 numbers")
    @Story("Calculate difference of 2 numbers")
    @Test
    public void tc2(){

        MySimpleCalculator calculator = new MySimpleCalculator();
        assertThat(calculator.sub2Num(5.0,4.0) ,equalTo(1.0));
    }
    
    @DisplayName("Calculate the product of 2 numbers")
    @Story("Calculate the product of 2 numbers")
    @Link("Software_testing") // @Link did not work
    @Test
    public void tc3(){

        MySimpleCalculator calculator = new MySimpleCalculator();
        assertThat(calculator.mul2Num(5.0,4.0) ,equalTo(20.0));
    }
    
    @Issue("Issue")
    @DisplayName("Divide 2 numbers")
    @Story("Divide 2 numbers")
    @Test
    public void tc4(){

        MySimpleCalculator calculator = new MySimpleCalculator();
        assertThat(calculator.div2Num(20.0,4.0) ,equalTo(6.0));
    }
    
    @DisplayName("Calculate the sum of two negative numbers")
    @Story("Calculate the sum of two numbers")
    @Description("""
                 This is a test method that will add 2 negative numbers,
                 This test focuses on the addition of 2 negative numbers & checks
                 if the result of the calculation is valid
                 """)
    @Test
    public void tc5(){
        CalculatorSteps calculate = new CalculatorSteps();
        calculate.add2Numbers(-3.0,-5.0);
        calculate.add2Numbers(-3.0,-5.0);
        assertThat(calculate.add2Numbers(-3.0, -5.0) ,equalTo(-8.0));
    }
}
