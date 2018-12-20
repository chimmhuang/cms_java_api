package com.chimm.cms.domain.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Created by chimm on 2018/12/14 0014.
 *
 * 用户实体类
 */
@Data
@ToString
@Entity
@Table(name = "users")
@ApiModel(value = "user实体类")
public class User implements Serializable {

    @ApiModelProperty(value = "用户主键id",name = "uid",example = "SGWSE54321DGHJ54")
    @Id
    @Column(name = "uid")
    private String uid; //用户表主键

    @ApiModelProperty(value = "用户名",name = "username",example = "zhangsan")
    @Column(name = "username")
    private String username; //用户名

    @ApiModelProperty(value = "账号密码",name = "password",example = "123456")
    @Column(name = "password")
    private String password; //密码

}
