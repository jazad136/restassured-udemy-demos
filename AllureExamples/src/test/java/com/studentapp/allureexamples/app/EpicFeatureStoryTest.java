/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentapp.allureexamples.app;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
@Epic("Just an epic")
@Feature("Pass Feature")
public class EpicFeatureStoryTest {
    
    @DisplayName("I am just a test which will always pass")
    public void tc1() {
        assertTrue(true);
    }
}
