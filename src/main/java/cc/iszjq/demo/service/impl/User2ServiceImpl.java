package cc.iszjq.demo.service.impl;

import cc.iszjq.demo.dao.User2Dao;
import cc.iszjq.demo.entity.User2;
import cc.iszjq.demo.service.User2Service;
import cc.iszjq.demo.utiles.MailUtil;
import cc.iszjq.demo.utiles.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Dao user2Dao;

    @Override
    public void register(User2 user2) throws Exception {
        user2.setState(0);
        String code = UUIDUtil.getUUID() + UUIDUtil.getUUID();
        user2.setCode(code);
        user2Dao.register(user2);
        MailUtil.sendMail(user2.getEmail(), user2.getCode());
    }

    @Override
    public User2 findByCode(String code) {
        User2 user2 = user2Dao.findByCode(code);
        if (user2 != null) {
            user2.setState(1);
            user2.setCode(null);
            user2Dao.updateUser(user2);
            return user2;
        }
        return null;
    }

    @Override
    public void update(User2 user2) {
        user2Dao.updateUser(user2);
    }
}
