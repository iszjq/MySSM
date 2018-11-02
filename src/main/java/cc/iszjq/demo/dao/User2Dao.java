package cc.iszjq.demo.dao;

import cc.iszjq.demo.entity.User2;

public interface User2Dao {
    void register(User2 user2);

    User2 findByCode(String code);

    void updateUser(User2 user2);
}
