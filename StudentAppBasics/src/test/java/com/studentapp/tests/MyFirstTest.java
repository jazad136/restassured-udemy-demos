package com.studentapp.tests;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JonathanSaddler
 */
public class MyFirstTest {
    private void styles() { 
        given()
                
                .when()
                
                .then();
        
        given()
                
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
        
        given()
                .expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8080/student/list");
    }
}
