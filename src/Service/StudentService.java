package Service;

import Modal.Student;

import java.util.List;

public interface StudentService {
    //CRUD
    List<Student> getAllStudents();
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int id);
}
