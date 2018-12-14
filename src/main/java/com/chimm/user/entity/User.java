package com.chimm.user.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Created by chimm on 2018/12/14 0014.
 */
@Data
@ToString
public class User {

    private String uid; //`uid` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户表主键',
    private String name; //varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
    private String pwd; //`pwd` varchar(32) NOT NULL COMMENT '密码'

}
