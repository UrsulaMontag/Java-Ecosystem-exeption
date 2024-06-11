import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void getStudentById_throwsException_IfStudentIdIsNotValid() {
        StudentService studentService = new StudentService();
        assertThrows(Exception.class, () -> studentService.getStudentById("invalid-id"));
    }
}