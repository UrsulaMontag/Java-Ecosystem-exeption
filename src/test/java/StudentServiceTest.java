import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void getStudentById_throwsIDNotNullException_IfStudentIdIsNotValid() {
        StudentService studentService = new StudentService();
        assertThrows(IDNotNullException.class, () -> studentService.getStudentById("invalid-id"));
    }

    @Test
    void getStudentById_returnsStudent_IfStudentIdIsValid() {
        Student student = new Student("id-1", "Max", "Test");
        StudentService studentService = new StudentService();
        studentService.addNewStudent(student);
        Student studentExpected = studentService.getAllStudents().getFirst();
        String studentExpectedId = studentService.getAllStudents().getFirst().id();

        try {
            assertEquals(studentExpected, studentService.getStudentById(studentExpectedId));
        } catch (IDNotNullException e) {
        }
    }
}