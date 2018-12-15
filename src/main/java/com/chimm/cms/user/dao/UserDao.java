package com.chimm.cms.user.dao;

import com.chimm.cms.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Created by huangs on 2018/12/15 0015.
 */
@Repository
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    /**
     * 通过用户名和密码查找对应的User对象
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User findByUsernameAndPassword(String username,String password);

}
