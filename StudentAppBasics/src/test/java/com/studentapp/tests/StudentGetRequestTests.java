package com.studentapp.tests;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JonathanSaddler
 */
public class StudentGetRequestTests extends TestBase{
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
//                .get("/list")
//                .then()
//                .statusCode(200);
        
        given()
                .expect()
                .statusCode(200)
                .when()
                .get("/list");
    }
    
    @DisplayName("Get a CS Student from the list")
    @Test
    void getSingleCSStudent() { 
        Map<String, Object> params = new HashMap<>();
        params.put("programme", "Computer Science");
        params.put("limit", 1);
        
        var response = given()
//                .queryParam("programme", "Computer Science")
//                .queryParam("limit", 1)
                .queryParams(params)
                .when()
                .get("/list");
        response.prettyPrint();
    }
    @Test
    void getTheSecondStudent() {
        var response = 
                given()
                .pathParam("id", 2)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }
}
