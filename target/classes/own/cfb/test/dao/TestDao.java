package own.cfb.test.dao;

import org.apache.ibatis.annotations.*;
import own.cfb.test.model.Student;

import java.util.List;

public interface TestDao {

    public List<Student> getStudentList();
}
