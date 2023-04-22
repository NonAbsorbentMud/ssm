package own.cfb.test.domain;

public class ObjectParam {
    private String fieldParam;

    public String getFieldParam() {
        return fieldParam;
    }

    public void setFieldParam(String fieldParam) {
        this.fieldParam = fieldParam;
    }

    @Override
    public String toString() {
        return "ObjectParam{" +
                "fieldParam='" + fieldParam + '\'' +
                '}';
    }
}
