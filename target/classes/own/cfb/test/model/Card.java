package own.cfb.test.model;

import java.io.Serializable;

public class Card implements Serializable {
    private Integer cardCode;//卡号
    private Double value;//金额
    private Student student;//学生

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getCardCode() {
        return cardCode;
    }

    public void setCardCode(Integer cardCode) {
        this.cardCode = cardCode;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardCode=" + cardCode +
                ", value=" + value +
                '}';
    }
}
