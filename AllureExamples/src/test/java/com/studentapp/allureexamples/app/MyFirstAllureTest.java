package com.studentapp.allureexamples.app;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("All tools for calculation")
@Feature("I just pass")
public class MyFirstAllureTest {
    @DisplayName("My first allure test")
    @Test
    public void tc1() { 
        assertTrue(true);
    }
}
