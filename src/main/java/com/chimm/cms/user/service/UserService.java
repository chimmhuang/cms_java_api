package com.chimm.cms.user.service;

import com.chimm.cms.core.response.CommonCode;
import com.chimm.cms.user.dao.UserDao;
import com.chimm.cms.domain.user.User;
import com.chimm.cms.domain.user.response.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by chimm on 2018/12/14 0014.
 *
 * 用户模块service层
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 登陆
     * @param user
     * @return
     */
    public UserResult login(User user) {
        User user1 = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user1 != null) {
            return new UserResult(CommonCode.SUCCESS,user1);
        }
        return new UserResult(CommonCode.FAIL, null);
    }


}
