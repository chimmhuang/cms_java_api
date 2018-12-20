package com.chimm.cms.user.controller;

import com.chimm.cms.base.controller.BaseController;
import com.chimm.cms.base.utils.CookieUtil;
import com.chimm.cms.base.domain.response.CommonCode;
import com.chimm.cms.domain.user.User;
import com.chimm.cms.domain.user.response.UserCode;
import com.chimm.cms.domain.user.response.UserResult;
import com.chimm.cms.user.service.UserService;
import io.swagger.annotations.*;
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
@Api(tags = "用户模块相关接口")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param user 用户实体类
     * @return
     */
    @ApiOperation(value = "用户登录",notes = "该接口会往浏览器写入Cookie（登录TOKEN），有效期为10天")
    @ApiResponses({
            @ApiResponse(code = 10000,message = "登录成功！"),
            @ApiResponse(code = 11111,message = "如果传入参数都为空，则操作失败！"),
            @ApiResponse(code = 21002,message = "用户名为空！"),
            @ApiResponse(code = 21003,message = "密码为空！"),
            @ApiResponse(code = 21004,message = "用户名或密码错误！")
    })
    @PostMapping("/login")
    public UserResult login(@RequestBody @ApiParam(name = "user",value = "不需要uid",required = true) User user) {

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
            //CookieUtil.setCookie(request,response,"CMS_TOKEN",user1.getUsername());
            Cookie cookie = new Cookie("CMS_TOKEN",user1.getUsername());
            response.addCookie(cookie);
            response.addHeader("x-auth-token",user1.getUsername());
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
    @ApiOperation(value = "获取cookie自动登录",notes = "该接口会获取前台传入的Cookie（登录TOKEN）进行登录")
    @ApiResponses({
            @ApiResponse(code = 10000,message = "登录成功！"),
            @ApiResponse(code = 21001,message = "Cookie中没有用户信息！"),
            @ApiResponse(code = 21005,message = "session中没有用户信息！"),
    })
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
