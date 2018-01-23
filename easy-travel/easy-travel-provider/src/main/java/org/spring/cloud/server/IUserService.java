package org.spring.cloud.server;

import org.spring.cloud.enitiy.User;

/**
 * <ul>
 * <li>文件包名 : org.spring.cloud.server</li>
 * <li>创建时间 : 2018/1/11 17:53</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author jiaonanyue
 * @version 2.0.0
 */
public interface IUserService {

    /**
     *
     * @param name
     * @return
     */
    User findUserByName(String name);

    /**
     *
     * @param user
     */
    void add(User user);

    /**
     *
     * @param id
     * @return
     */
    User get(long id);


}
