package com.chimm.cms.user.controller;

import com.chimm.cms.core.response.ResponseResult;
import com.chimm.cms.domain.user.User;
import com.chimm.cms.domain.user.response.UserResult;
import com.chimm.cms.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by chimm on 2018/12/14 0014.
 *
 * 用户模块
 */
@RestController
@RequestMapping("/user")
@Api(value = "cms用户登录接口",description = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param user
     * @return
     */
    @ApiOperation("用户登录")
    @ApiParam(name = "用户对象",value = "传入json格式",required = true)
    @PostMapping("/login")
    public UserResult login(@RequestBody User user) {
        return userService.login(user);
    }

}
