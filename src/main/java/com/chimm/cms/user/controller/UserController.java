package com.chimm.cms.user.controller;

import com.chimm.cms.base.controller.BaseController;
import com.chimm.cms.base.utils.CookieUtil;
import com.chimm.cms.domain.response.CommonCode;
import com.chimm.cms.domain.user.User;
import com.chimm.cms.domain.user.response.UserCode;
import com.chimm.cms.domain.user.response.UserResult;
import com.chimm.cms.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

/**
 * @author Created by chimm on 2018/12/14 0014.
 *
 * 用户模块
 */
@RestController
@RequestMapping("/user")
@Api(value = "cms用户登录接口",description = "用户模块")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param user
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ApiParam(name = "用户对象",value = "传入json格式",required = true)
    public UserResult login(@RequestBody User user) {

        //接受参数校验
        if (user == null) {
            return new UserResult(CommonCode.FAIL, null);
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            return new UserResult(UserCode.USER_USERNAME_IS_NULL, null);
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return new UserResult(UserCode.USER_PASSWORD_IS_NULL, null);
        }

        //调用服务进行登录
        User user1 = userService.login(user);

        if (user1 != null) {
            //设置cookie和session
            request.getSession().setAttribute(user1.getUsername(),user1);
            CookieUtil.setCookie(request,response,"CMS_TOKEN",user1.getUsername());
            return new UserResult(CommonCode.SUCCESS, user1);
        } else {
            return new UserResult(UserCode.USER_LOGIN_FAIL, null);
        }
    }


    /**
     * 获取cookie进行自动登录
     * @return
     */
    @PostMapping("/autoLogin")
    @ApiOperation(value = "获取cookie自动登录",notes = "通过前台传入的cookie进行登录")
    @ApiParam(name = "用户对象",value = "传入json格式",required = true)
    public UserResult autoLogin() {
        String cmsToken = CookieUtil.getCookieValue(request, "CMS_TOKEN", "utf-8");

        if (StringUtils.isEmpty(cmsToken)) {
            //cookie中没有用户登录的信息
            return new UserResult(UserCode.USER_NO_COOKIE_VALUE, null);
        } else {
            //cookie中有用户登录信息
            User user_session = (User) request.getSession().getAttribute(cmsToken);
            if (user_session == null) {
                //session中没有用户信息
                return new UserResult(UserCode.USER_NO_SESSOION_VALUE, null);
            } else {
                //session中有用户
                return new UserResult(CommonCode.SUCCESS,user_session);
            }
        }
    }

    @ApiOperation(value = "测试数据库的，不用管")
    @PostMapping("/test")
    public User test(User user) {
        return userService.test(user);
    }

}
