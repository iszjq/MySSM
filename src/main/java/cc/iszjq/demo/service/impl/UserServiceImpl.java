package cc.iszjq.demo.service.impl;

import cc.iszjq.demo.dao.UserDao;
import cc.iszjq.demo.entity.User;
import cc.iszjq.demo.service.UserService;
import cc.iszjq.demo.utiles.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int checkName(String userName) {
        User user = userDao.findByUserName(userName);
        if (user != null)
            return 1;
        return 0;
    }

    @Override
    public User checkLogin(String userName, String password) {
        password = MD5Util.encodeToHex(userName + password + "salt");
        User user = userDao.findByUserName(userName);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public int register(User user) {
        user.setPassword(MD5Util.encodeToHex(user.getUserName() + user.getPassword() + "salt"));
        return userDao.registerByUserNameAndPassword(user.getUserName(), user.getPassword());
    }
}
