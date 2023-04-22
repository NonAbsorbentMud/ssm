package own.cfb.converters;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String, String> {
    @Override
    public String convert(String s) {
        System.out.println("Converter字符串："+s);
        return s.replaceAll(" ","");
    }
}
