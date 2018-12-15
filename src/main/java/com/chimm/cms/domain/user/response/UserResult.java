package com.chimm.cms.domain.user.response;

import com.chimm.cms.core.response.ResponseResult;
import com.chimm.cms.core.response.ResultCode;
import com.chimm.cms.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Created by huangs on 2018/12/15 0015.
 */
@Data
@NoArgsConstructor
public class UserResult extends ResponseResult {
    User user;
    public UserResult(ResultCode resultCode,User user) {
        super(resultCode);
        this.user = user;
    }
}
