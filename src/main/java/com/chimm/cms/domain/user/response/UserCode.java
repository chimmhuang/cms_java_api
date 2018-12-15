package com.chimm.cms.domain.user.response;

import com.chimm.cms.core.response.ResultCode;
import lombok.ToString;

/**
 * @author Created by huangs on 2018/12/15 0015.
 */
@ToString
public enum UserCode implements ResultCode {;

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;


    private UserCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
