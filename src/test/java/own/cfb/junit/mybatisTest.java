package own.cfb.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import own.cfb.mapper.MybatisTest;
import own.cfb.test.model.Student;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class mybatisTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException{
        String resource="mybatis/sqlMapConfig.xml";
        InputStream in =Resources.getResourceAsStream(resource);
        this.sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void mybatisTest() throws Exception {
        //this.readMybatisConfig();
        //this.useMapperByClassOrPackage();
        //this.operateData();
        //this.batchOperateData();
        //this.insertDataAndGetPrimaryKey();
        //this.getTypeHandlers();
    }
    /**
     * 获取类型处理器
     */
    public static void getTypeHandlers() {
        try{
            String resource="mybatis/sqlMapConfig.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TypeHandlerRegistry typeHandlerRegistry = sqlSession.getConfiguration().getTypeHandlerRegistry();
            Collection<TypeHandler<?>> handlers =  typeHandlerRegistry.getTypeHandlers();
            System.out.println(handlers.size());
            for (TypeHandler<?> typeHandler : handlers) {
                System.out.println(typeHandler.getClass().getName());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 插入数据并获取对应的主键
     */
    public void insertDataAndGetPrimaryKey(){
        try{
            String resource="mybatis/sqlMapConfig.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            MybatisTest mybatisTest = sqlSession.getMapper(MybatisTest.class);
            Student student=new Student();
            student.setStuName("dada");
            Integer flag = mybatisTest.saveStudentBySelectKey(student);
            //Integer flag = mybatisTest.saveStudentByUseGeneratedKeys(student);
            System.out.println("保存数据生成的主键："+student.getStuCode());
            sqlSession.commit();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 批量新增修改删除数据
     */
    public void batchOperateData(){
        try{
            String resource="mybatis/sqlMapConfig.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            MybatisTest mybatisTest = sqlSession.getMapper(MybatisTest.class);
            List<Student> studentList=new ArrayList<>();
            Student student=new Student();
            Student student1=new Student();
            student.setStuName("大大");
            student1.setStuName("大大");
            studentList.add(student);
            studentList.add(student1);
            Integer flag = mybatisTest.saveStudentList(studentList);
            System.out.println("批量插入insert标签返回的结果标识："+flag);
            System.out.println("批量插入返回的主键："+studentList.toString().toString());
            student.setStuName("无");
            student1.setStuName("无");
            flag=-1;
            flag = mybatisTest.updateStudentList(studentList);
            System.out.println("批量插入update标签返回的结果标识："+flag);
            flag=-1;
            flag= mybatisTest.deleteStudentList(studentList);
            System.out.println("批量删除delete标签返回的结果标识："+flag);
            flag=-1;
            flag= mybatisTest.deleteStudentByStuName("大大");
            System.out.println("批量删除delete标签返回的结果标识："+flag);
            List<Student> stus = mybatisTest.getStudentList();
            System.out.println("学生列表："+stus.toString().toString());
            sqlSession.commit();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 新增修改删除查询数据
     */
    public void operateData(){
        try {
            String resource="mybatis/sqlMapConfig.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            MybatisTest mybatisTest = sqlSession.getMapper(MybatisTest.class);
            Student student=new Student();
            student.setStuName("大大");
            Integer flag = mybatisTest.saveStudent(student);
            System.out.println("插入insert标签返回的结果标识："+flag);
            student.setStuName("无");
            flag=-1;
            flag= mybatisTest.updateStudent(student);
            System.out.println("修改update标签返回的结果标识："+flag);
            flag=-1;
            flag= mybatisTest.deleteStudent(student);
            System.out.println("删除delete标签返回的结果标识："+flag);
            List<Student> stus = mybatisTest.getStudentList();
            System.out.println("学生列表："+stus.toString().toString());
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过class属性或package标签引入映射器
     */
    public void useMapperByClassOrPackage(){
        try {
            String resource="mybatis/sqlMapConfig.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            MybatisTest mybatisTest = sqlSession.getMapper(MybatisTest.class);
            List<Student> stus = mybatisTest.getStudentList();
            System.out.println("学生列表："+stus.toString().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取mybatis配置文件
     */
    public void readMybatisConfig(){
        try {
            //加载核心配置文件
            String resource="mybatis/sqlMapConfig.xml";
            InputStream in= null;
            in = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            //创建SqlSession
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //执行sql
            List<Student> stus = sqlSession.selectList("test.getStudentList");
            System.out.println("学生列表："+stus.toString().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
