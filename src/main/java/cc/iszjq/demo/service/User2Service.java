package cc.iszjq.demo.service;

import cc.iszjq.demo.entity.User2;

public interface User2Service {
    void register(User2 user2) throws Exception;

    User2 findByCode(String code);

    void update(User2 user2);
}
