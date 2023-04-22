package own.cfb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,value = HttpStatus.BAD_REQUEST,reason="自定义异常")
public class MyException extends RuntimeException{
}
