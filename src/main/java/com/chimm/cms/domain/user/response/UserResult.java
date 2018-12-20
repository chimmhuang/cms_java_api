package com.chimm.cms.domain.user.response;

import com.chimm.cms.base.domain.response.ResponseResult;
import com.chimm.cms.base.domain.response.ResultCode;
import com.chimm.cms.domain.user.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Created by huangs on 2018/12/15 0015.
 */
@Data
@NoArgsConstructor
@ApiModel(value = "用户模块的返回结果")
public class UserResult extends ResponseResult {
    User user;
    public UserResult(ResultCode resultCode,User user) {
        super(resultCode);
        this.user = user;
    }
}
