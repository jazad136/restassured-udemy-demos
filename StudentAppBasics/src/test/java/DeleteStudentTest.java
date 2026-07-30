

import com.studentapp.tests.*;
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
public class DeleteStudentTest extends TestBase{
    @DisplayName("Delete a student from the system")
    @Test
    void updateStudent() {
        given()
        .when()
        .contentType(ContentType.JSON)
        .when()
        .delete("/101")
        .then()
        .statusCode(204);
    }
}
