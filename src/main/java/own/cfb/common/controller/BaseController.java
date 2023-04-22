package own.cfb.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/base")
public class BaseController {

    @RequestMapping("/navTo/{moduleName}/{pageName}")
    public String toJsp(@PathVariable(value="moduleName",required=false) String moduleName,
                              @PathVariable(value="pageName",required=true) String pageName){
        if(moduleName==null || moduleName.equals("0")){
            moduleName="";
        }
        String url=moduleName+"/"+pageName;
        System.out.println("url:"+url);
        return url;
    }
}
