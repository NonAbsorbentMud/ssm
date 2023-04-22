package own.cfb.user.service;

import own.cfb.user.model.Users;

public interface UserService {

    public Users login(String account,String pwd);

}
