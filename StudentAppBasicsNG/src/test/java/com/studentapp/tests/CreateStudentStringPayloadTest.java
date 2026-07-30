package com.studentapp.tests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class CreateStudentStringPayloadTest extends TestBase{
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
        iFormat("RestAssured baseURI: " + baseURI);
        iFormat("RestAssured port: " + baseURI);
        iFormat("RestAssured basePath: " + basePath);
        given()
        .when()
        .contentType(ContentType.JSON)
        .when()
        .body(payload)
        .post()
        .then()
        .statusCode(201);
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return "CreateStudentStringPayloadTest";
    }
}
