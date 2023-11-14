package Service.ServiceImpl;

import Modal.Student;
import Service.StudentService;
import helpers.PropertiesUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentServiceImpl implements StudentService {
    private static Properties properties = PropertiesUtils.readProperties();
    private static final String USERNAME = properties.getProperty("db.username");
    private static final String PASSWORD= properties.getProperty("db.password");
    private  static final String  URL = properties.getProperty("db.url");
//    private static final String USERNAME="postgres";
//    private static final String PASSWORD="171103";
//    private static final String URL="jdbc:postgresql://localhost:5432/TestDB";


    public  List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        try(
                Connection connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            // executeQuery() : for select
            // executeUpdate() : other than select ( insert, update ,delete....
            ResultSet resultSet =  statement.executeQuery("select * from student_tb");
            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                        ,resultSet.getString("gender")
                        ,resultSet.getString("classroom")
                        ,resultSet.getFloat("scores"),
                        resultSet.getTimestamp("created_time")
                ));

            }
            return  students;

        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    private static final String   INSERT_SQL= """
            INSERT INTO student_tb
             (name,gender,classroom,scores,created_time)
             VALUES (?,?,?,?,now())
            
            """;

    public  int insertStudent(Student student){
        try(
                Connection connection =
                        DriverManager
                                .getConnection(URL,USERNAME,PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)
        ){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getGender() );
            preparedStatement.setString(3,student.getClassroom());
            preparedStatement.setFloat(4,student.getScores());

            return   preparedStatement.executeUpdate();

        }catch (SQLException ex ){
            ex.printStackTrace();
            return 0;
        }


    }
    private static final String DELETE_SQL = """
            delete from student_tb where id = ?
            """;
    public  int deleteStudent(int id ){
        try(
                Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                PreparedStatement ps = connection.prepareStatement(DELETE_SQL)
        ){

            ps.setInt(1,id);
            return ps.executeUpdate();

        }catch (SQLException ex ){
            ex.printStackTrace();
            return 0;
        }
    }
    private static final String UPDATE_SQL= """
            UPDATE student_tb set
             name = ?, gender=?, classroom=?, scores=?
             where id = ?
            """;

    public  int updateStudent(Student student){
        try(
                Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)

        ){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getGender());
            preparedStatement.setString(3,student.getClassroom());
            preparedStatement.setFloat(4,student.getScores());
            preparedStatement.setInt(5,student.getId());


            return  preparedStatement.executeUpdate();


        }catch (SQLException ex ){
            ex.printStackTrace();
            return 0;
        }


    }




//    public static List<Student> getAllStudents(){
//        //try with resource -> iml outoclosable
//        try(
//                Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//                Statement statement =connection.createStatement();
//                ){
//            //executeQuery
//            //executeUpdate
//            ResultSet resultSet =  statement.executeQuery("select * from student_tb");
//            while(resultSet.next()){
//                System.out.println("Student ID"+resultSet.getInt("id"));
//                System.out.println("Name :"+resultSet.getString("name"));
//            }
//           //ResultSet resultSet= statement.executeQuery("select * from student_tb");
//
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
}
