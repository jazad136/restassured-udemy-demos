package com.studentapp.tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JonathanSaddler
 */
public class MyFirstTest {
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
    @DisplayName("Getting all the student from the database")
    void getAllStudents() { 
        /*
        RequestSpecification requestSpec = RestAssured.given();
        Response response = requestSpec.get("http://localhost:8080/student/list");
        response.prettyPrint();
        
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        */
//        RestAssured.given()
//                .when()
//                .get("http://localhost:8080/student/list")
//                .then()
//                .statusCode(200);
        
        RestAssured.given()
                .expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8080/student/list");
    }
}
