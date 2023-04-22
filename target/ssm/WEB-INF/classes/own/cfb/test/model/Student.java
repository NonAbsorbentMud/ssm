package own.cfb.test.model;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer stuCode;//学生编号
    private String stuName;//学生名称
    private Card card;//学生卡
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getStuCode() {
        return stuCode;
    }

    public void setStuCode(Integer stuCode) {
        this.stuCode = stuCode;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuCode=" + stuCode +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
