import Service.ServiceImpl.StudentServiceImpl;
import Service.StudentService;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();

        System.out.println("Here are all the students ");
        System.out.println(studentService.getAllStudents());
    }
}
