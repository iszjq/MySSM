package cc.iszjq.demo.service;

import cc.iszjq.demo.entity.User;

public interface UserService {

    /**
     * Check Login
     *
     * @param userName
     * @param password
     * @return
     */
    User checkLogin(String userName, String password);

    /**
     * Register By User
     *
     * @param user
     */
    int register(User user);

    /**
     * @param userName
     * @return
     */
    int checkName(String userName);

}
