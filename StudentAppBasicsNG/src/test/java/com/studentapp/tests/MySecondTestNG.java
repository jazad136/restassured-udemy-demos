package com.studentapp.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class MySecondTestNG extends RequestTest {
    @Test
    void getAllStudents() { 
        RequestSpecification requestSpec = RestAssured.given();
        
        Response response = requestSpec.get("http://localhost:8080/student/list");
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
    
}
