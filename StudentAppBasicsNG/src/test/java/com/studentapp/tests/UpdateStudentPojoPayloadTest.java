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
public class UpdateStudentPojoPayloadTest extends TestBase{
    @Test
    void updateStudent() {
        Faker fake = new Faker();
        StudentPojo student = new StudentPojo();
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

    @Override
    public String retrieveTestNameSuffix(ITestResult res) {
        return "UpdateStudentPojoPayloadTest";
    }
    
}
