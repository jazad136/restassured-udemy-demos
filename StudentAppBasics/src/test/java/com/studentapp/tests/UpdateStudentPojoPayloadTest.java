package com.studentapp.tests;

import com.studentapp.model.StudentPojo;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.util.List;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JonathanSaddler
 */
public class UpdateStudentPojoPayloadTest extends TestBase{
    @DisplayName("Update a new student by sending payload as string")
    @Test
    void updateStudent() {
        Faker fake = new Faker();
        StudentPojo student = new StudentPojo();
//        student.setFirstName("John");
//        student.setLastName("John");
//        student.setEmail("John2@gmail.com");
//        student.setProgramme("ComputerScience");
//        student.setCourses(List.of("C++","JAVA"));
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("ComputerScience");
        student.setCourses(List.of("C++","JAVA"));
        given()
        .when()
        .contentType(ContentType.JSON)
        .when()
        .body(student)
        .put("/101")
        .then()
        .statusCode(200);
    }
}
