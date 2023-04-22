package own.cfb.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.cfb.user.dao.UserDao;
import own.cfb.user.model.Users;
import own.cfb.user.service.UserService;
import own.cfb.utils.RegexpUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users login(String account, String pwd) {
        boolean flag=RegexpUtil.checkIdCard(account);
        System.out.println("是否为身份证："+flag);
        Users users=new Users();
        if(flag){
            users=userDao.getUserByIdCard(account);
        }else{
            flag=RegexpUtil.checkPhone(account);
            System.out.println("是否为手机号："+flag);
            if(flag){
                users=userDao.getUserByPhone(account);
            }else{
                flag=RegexpUtil.checkNumber(account);
                System.out.println("是否为用户编号："+flag);
                if(flag){
                    users=userDao.getUserByUserId(Integer.valueOf(account));
                }else{
                    throw new RuntimeException("账号格式不正确!");
                }
            }
        }
        if(users!=null){
            if(!users.getPassword().equals(pwd)){
                throw new RuntimeException("密码错误!");
            }
        }else{
            throw new RuntimeException("用户不存在！");
        }
        return users;
    }
}
