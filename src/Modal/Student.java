package Modal;

import java.sql.Timestamp;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String classroom;
    private float scores;
    private Timestamp createdDate;
    public Student(){}
    public Student(int id,String name,String gender,String classroom,float scores,Timestamp createdDate){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.classroom=classroom;
        this.scores=scores;
        this.createdDate=createdDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public float getScores() {
        return scores;
    }

    public void setScores(float scores) {
        this.scores = scores;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classroom='" + classroom + '\'' +
                ", scores=" + scores +
                ", createdDate=" + createdDate +
                '}'+'\n';
    }
}
