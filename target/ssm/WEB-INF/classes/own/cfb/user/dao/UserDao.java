package own.cfb.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import own.cfb.user.model.Users;

@Scope(value="prototype")
public interface UserDao {

    public Users getUserByIdCard(@Param("idCard") String idCard);

    public Users getUserByPhone(@Param("phone") String phone);

    public Users getUserByUserId(@Param("userId") Integer userId);
}
