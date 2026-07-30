/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentapp.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.studentapp.tests.config.ExtentReportManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

/**
 * @author JonathanSaddler
 */
public abstract class TestBase {
    protected ExtentReports extent;
    protected ExtentTest testReport;
    protected SoftAssert softAssert;
    private String testNameSuffix;
    
    @BeforeMethod
    @Parameters({"testNamePrepend"})
    public void setup(ITestResult res, @Optional String testNamePrepend) {
        extent = ExtentReportManager.getReporter();
        testNamePrepend = testNamePrepend != null && !testNamePrepend.equals("testNamePrepend") ? testNamePrepend : "";
        softAssert = new SoftAssert();
        setTestNameSuffix(retrieveTestNameSuffix(res));
        String fullTestName = getFullTestName(testNamePrepend);
        this.testReport = extent.createTest(fullTestName);
        res.setAttribute("reporterObject", testReport);
    }
    
    @AfterMethod
    public void teardown() { 
        extent.flush();
    }
    
    protected void setTestNameSuffix(String testNameSuffix) { this.testNameSuffix = testNameSuffix; } 
    protected String getTestNameSuffix() { return testNameSuffix; }
    public abstract String getFullTestName(String prepend);
    public abstract String retrieveTestNameSuffix(ITestResult res);
}
