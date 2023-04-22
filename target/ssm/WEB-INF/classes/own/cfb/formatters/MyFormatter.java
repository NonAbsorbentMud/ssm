package own.cfb.formatters;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyFormatter implements Formatter<String> {
    @Override
    public String parse(String s, Locale locale) throws ParseException {
        System.out.println("Converter字符串："+s);
        return s.replaceAll(" ","");
    }

    @Override
    public String print(String str, Locale locale) {
        return str;
    }
}
