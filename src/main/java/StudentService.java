import java.util.List;
import java.util.UUID;

public class StudentService {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public Student getStudentById(String studentId) throws IDNotNullException {
//        Student result = null;
//        if (repo.findStudentById(studentId).isPresent()) result = repo.findStudentById(studentId).get();
//        else throw new IDNotNullException("Student with id " + studentId + " not found");
//        return result;
        return repo.findStudentById(studentId).orElseThrow(() -> new IDNotNullException("Student with id " + studentId + " not found"));
    }
}
