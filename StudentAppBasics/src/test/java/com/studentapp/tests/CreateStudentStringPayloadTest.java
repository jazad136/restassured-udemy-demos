package com.studentapp.tests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JonathanSaddler
 */
public class CreateStudentStringPayloadTest extends TestBase{
    @DisplayName("Create a new student by sending payload as string")
    @Test
    void createNewStudent() {
        String payload = """
          {
          \"firstName\": \"test2\",
          \"lastName\": \"User\",
          \"email\": \"test5@gmail.com\",
          \"programme\": \"Computer Science\",
          \"courses\": [\"C++\",\"JAVA\"]
          }"
        """
        ;
        given()
        .when()
        .contentType(ContentType.JSON)
        .when()
        .body(payload)
        .post()
        .then()
        .statusCode(201);
    }
}
