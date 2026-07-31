package com.studentapp.allureexamples.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Assert the value true is true")
public class MyFirstAllureTest {
    @DisplayName("My first allure test")
    @Test
    public void tc1() { 
        assertTrue(true);
    }
}
