package own.cfb.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import own.cfb.user.model.Users;
import own.cfb.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(@RequestParam("account") String account, @RequestParam("pwd") String pwd){
        Users users=userService.login(account,pwd);
        System.out.println("登入的用户信息："+users.toString());
        return "main";
    }
}
