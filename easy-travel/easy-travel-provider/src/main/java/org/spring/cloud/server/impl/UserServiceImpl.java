package org.spring.cloud.server.impl;

import org.spring.cloud.dao.UserDAO;
import org.spring.cloud.enitiy.User;
import org.spring.cloud.server.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <ul>
 * <li>文件包名 : org.spring.cloud.server.impl</li>
 * <li>创建时间 : 2018/1/11 17:54</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author jiaonanyue
 * @version 2.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User findUserByName(String name) {
        return userDAO.findUserByName(name);
    }

    @Override
    @Transactional()
    public void add(User user) {

         userDAO.save(user);
    }

    @Override
    @Transactional
    public User get(long id) {
        return userDAO.findOne(id);
    }


}
