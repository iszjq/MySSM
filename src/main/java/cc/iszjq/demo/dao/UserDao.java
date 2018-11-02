package cc.iszjq.demo.dao;

import cc.iszjq.demo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * @param userName 用户名
     * @return
     */
    User findByUserName(String userName);

    /**
     * 注册用户密码
     *
     * @param userName 用户名
     * @param password 用户密码
     * @return
     */
    int registerByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
