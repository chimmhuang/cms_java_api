package com.chimm.cms.domain.linkman.response;

import com.chimm.cms.base.domain.response.ResponseResult;
import com.chimm.cms.base.domain.response.ResultCode;
import com.chimm.cms.domain.linkman.LinkMan;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Created by huangs on 2018/12/22 0022.
 */
@Data
@NoArgsConstructor
@ApiModel(value = "联系人模块的返回结果")
public class LinkmanResult  extends ResponseResult {

    private LinkMan linkMan;

    public LinkmanResult(ResultCode resultCode,LinkMan linkMan) {
        super(resultCode);
        this.linkMan = linkMan;
    }
}
