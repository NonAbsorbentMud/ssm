package own.cfb.test.controller;


import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import own.cfb.exception.FirstException;
import own.cfb.exception.MyException;
import own.cfb.test.domain.ObjectParam;
import own.cfb.test.model.Student;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;


@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/beanParam")
    public String beanParam(ObjectParam objectParam) {
        System.out.println("实体类bean:" + objectParam.toString());
        return "test/result";
    }

    @RequestMapping("shapeParam")
    public String shapeParam(String fieldParam) {
        System.out.println("形参:" + fieldParam);
        return "test/result";
    }

    @RequestMapping("httpRequestParam")
    public String httpRequestParam(HttpServletRequest request) {
        System.out.println("HttpServletRequest:" + request.getParameter("fieldParam"));
        return "test/result";
    }

    @RequestMapping("/pathValue/{fieldParam}")
    public String pathVariableParam(@PathVariable String fieldParam) {
        System.out.println("PathVariable:" + fieldParam);
        return "test/result";
    }

    @RequestMapping("requestParam")
    public String requestParam(@RequestParam("fieldParam") String fieldParam) {
        System.out.println("RequestParam:" + fieldParam);
        return "test/result";
    }

    @RequestMapping("modelAttributeParam")
    public String modelAttributeParam(@ModelAttribute("objectParam") ObjectParam objectParam) {
        System.out.println("ModelAttribute:" + objectParam.toString());
        return "test/result";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView returnDataByModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("field", "ModelAndView");
        modelAndView.setViewName("test/result");
        return modelAndView;
    }

    @RequestMapping("/string")
    public String returnDataByString() {
        return "test/result";
    }

    @RequestMapping("/result")
    public void returnDataByVoid() {
    }

    @ResponseBody
    @RequestMapping("/anyData")
    public ObjectParam returnDataByAnyData() {
        ObjectParam objectParam = new ObjectParam();
        objectParam.setFieldParam("123");
        return objectParam;
    }

    @RequestMapping("/navToTypeByForwardForModel")
    public ModelAndView navToTypeByForwardForModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("field", "ModelAndView");
        modelAndView.setViewName("forward:/WEB-INF/jsp/test/result.jsp");
        return modelAndView;
    }

    @RequestMapping("/navToTypeByRedirectForModel")
    public ModelAndView navToTypeByRedirectForModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/test/navToTypeByForwardForModel");
        return modelAndView;
    }

    @RequestMapping("/navToTypeByForwardForString")
    public String navToTypeByForwardForString() {
        return "forward:/WEB-INF/jsp/test/result.jsp";
    }

    @RequestMapping("/navToTypeByRedirectForString")
    public String navToTypeByRedirectForString() {
        return "redirect:/test/navToTypeByForwardForString";
    }

    @RequestMapping("/testConverter")
    public String testConverter(String str, Model model) {
        System.out.println("类型转换器：" + str);
        model.addAttribute("date", str);
        return "test/result";
    }

    @RequestMapping("/testFormatter")
    public String testFormatter(@NumberFormat(style = NumberFormat.Style.CURRENCY) BigDecimal money, Model model) {
        System.out.println("格式化转换器：" + money);
        model.addAttribute("money", money);
        return "test/result";
    }

    @RequestMapping(value = "/testDefaultHandlerExceptionResolver", method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver() {
        return "test/result";
    }

    @RequestMapping(value = "/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver() {
        throw new MyException();
    }

    @RequestMapping(value = "/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver() {
        throw new ArithmeticException("自定义异常处理");
    }

    @ExceptionHandler(ArithmeticException.class)
    public String handleException(ArithmeticException exception) {
        return "error";
    }

    @RequestMapping(value = "/testExceptionHandlerExceptionResolveByGlobal")
    public String testExceptionHandlerExceptionResolverByGlobal() {
        throw new RuntimeException("全局自定义异常处理");
    }

    @RequestMapping(value = "/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver() {
        throw new FirstException();
    }

    @ResponseBody
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("fileData") MultipartFile fileData, HttpServletRequest req) {
        if (fileData.isEmpty()) {
            if (fileData.getSize() > (3 * 1024 * 1024)) {
                return "4---上传文件大于3M!";
            } else {
                String fileName = fileData.getOriginalFilename();
                String fileType = fileName.substring(fileName.indexOf('.') + 1);
                if (fileType.equals("jpg") || fileType.equals("png")) {
                    String path = req.getContextPath();
                    System.out.println("路径："+path);
                    return "3---上传成功";
                } else {
                    return "2---上传文件类型不支持" + fileType;
                }
            }
        } else {
            return "1---上传文件为空";
        }
    }
}
