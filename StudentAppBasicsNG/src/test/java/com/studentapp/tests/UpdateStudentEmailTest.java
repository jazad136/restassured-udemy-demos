package com.studentapp.tests;

import com.studentapp.model.StudentPojo;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.util.List;
import net.datafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class UpdateStudentEmailTest extends TestBase{
    @Test
    void updateStudent() {
        Faker fake = new Faker();
        StudentPojo student = new StudentPojo();

        student.setEmail(fake.internet().emailAddress());

        i("RestAssured baseURI: " + baseURI);
        i("RestAssured port: " + baseURI);
        i("RestAssured basePath: " + basePath);
        given()
        .when()
        .contentType(ContentType.JSON)
        .when()
        .body(student)
        .patch("/101")
        .then()
        .statusCode(200);
    }

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return "UpdateStudentPojoPayloadTest";
    }
    
}
