package own.cfb.test.model;

import java.io.Serializable;
import java.util.Set;

public class Teacher implements Serializable {

    private Integer teaCode;//教师编号
    private String teaName;//教师名称
    private Set<Student> students;//学生列表

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Integer getTeaCode() {
        return teaCode;
    }

    public void setTeaCode(Integer teaCode) {
        this.teaCode = teaCode;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
