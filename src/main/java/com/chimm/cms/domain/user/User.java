package com.chimm.cms.domain.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Created by chimm on 2018/12/14 0014.
 */
@Data
@ToString
@Entity
@Table(name = "users")
@ApiModel(value = "user对象",description = "用户对象user")
public class User implements Serializable {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private String uid; //用户表主键

    @ApiModelProperty(value = "用户名",name = "username",required = true)
    @Column(name = "username")
    private String username; //用户名

    @ApiModelProperty(value = "密码",name = "password",required = true)
    @Column(name = "password")
    private String password; //密码

}
