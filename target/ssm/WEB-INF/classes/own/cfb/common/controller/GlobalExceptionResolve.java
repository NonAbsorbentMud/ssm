package own.cfb.common.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionResolve{
    @ExceptionHandler(value=ArithmeticException.class)
    public String firstException(ArithmeticException arithmeticException, Model model){
        model.addAttribute("ex","ArithmeticException"+arithmeticException.getMessage());
        return "error";
    }
    @ExceptionHandler(value=RuntimeException.class)
    public String twoException(RuntimeException runtimeException, Model model){
        model.addAttribute("ex","RuntimeException"+runtimeException.getMessage());
        return "error";
    }
    @ExceptionHandler(value=Exception.class)
    public String twoException(Exception exception, Model model){
        model.addAttribute("ex","exception"+exception.getMessage());
        return "error";
    }
}
