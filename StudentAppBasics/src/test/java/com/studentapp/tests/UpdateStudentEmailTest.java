package com.studentapp.tests;


import com.studentapp.model.StudentPojo;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
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

        given()
        .when()
        .contentType(ContentType.JSON)
        .when()
        .body(student)
        .patch("/101")
        .then()
        .statusCode(200);
    }
    
}
