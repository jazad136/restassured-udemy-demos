package com.studentapp.tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class MyFirstTestNG {
    private void styles() { 
        RestAssured
                .given()
                
                .when()
                
                .then();
        
        RestAssured.given()
                
                .expect()
        
                .when();
    }
    
    @Test
    void getAllStudents() { 
        RequestSpecification requestSpec = RestAssured.given();
        
        Response response = requestSpec.get("http://localhost:8080/student/list");
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
