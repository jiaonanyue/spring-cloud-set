package org.spring.cloud.dao;

import org.spring.cloud.enitiy.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * <ul>
 * <li>文件包名 : org.spring.cloud.dao</li>
 * <li>创建时间 : 2018/1/11 17:50</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明：
 *
 * @author jiaonanyue
 * @version 2.0.0
 */
@Repository
@Table(name="user")
public interface UserDAO extends CrudRepository<User, Long > {


    /**
     *  通过名称查询
     * @param name
     * @return
     */
    @Query("select t from User t where t.userName=:name")
    User findUserByName(@Param("name") String name);
}
