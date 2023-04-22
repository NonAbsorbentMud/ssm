package own.cfb.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.mapping.FetchType;
import own.cfb.test.model.Student;

import java.util.List;

public interface MybatisTest {
    public List<Student> getStudentList();

    public Student getStudent(Integer stuCode);

    public Integer saveStudent(Student student);

    public Integer saveStudentBySelectKey(Student student);

    public Integer saveStudentByUseGeneratedKeys(Student student);

    public Integer updateStudent(Student student);

    public Integer deleteStudent(Student student);

    public Integer deleteStudentByStuName(String stuName);

    public  Integer saveStudentList(List<Student> studentList);

    public  Integer updateStudentList(List<Student> studentList);

    public  Integer deleteStudentList(List<Student> studentList);
}
