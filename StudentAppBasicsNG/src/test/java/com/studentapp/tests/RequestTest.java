/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentapp.tests;

import org.testng.ITestResult;

/**
 *
 * @author JonathanSaddler
 */
public class RequestTest extends TestBase {

    public RequestTest() {
    }

    @Override
    public String getFullTestName(String prepend) {
        String nameSuffix = getTestNameSuffix();
        String endTestName = nameSuffix != null && !nameSuffix.equals("testName") ? nameSuffix : "Request Test";
        return prepend + endTestName;
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return "Request Test";
    }
    
}
