package com.chimm.cms.domain.linkman.vo;

import com.chimm.cms.domain.linkman.LinkMan;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Created by huangs on 2018/12/29 0029.
 *
 * 联系人VO类
 */
@Data
@ToString
@NoArgsConstructor
@ApiModel("联系人VO类")
public class LinkManVo {

    @ApiModelProperty(name = "lid",value = "联系人主键",example = "1a3e6dc8225045ab9f0bf4ae56e98bde")
    private String lid; //联系人主键

    @ApiModelProperty(name = "name",value = "联系人姓名",example = "李四")
    private String name; //联系人姓名

    @ApiModelProperty(name = "address",value = "联系人住址",example = "中国四川省成都市金堂县")
    private String address; //联系人住址

    @ApiModelProperty(name = "phone",value = "联系人手机号",example = "13111111111")
    private String phone; //联系人11位手机号

    @ApiModelProperty(name = "birthday",value = "联系人生日",example = "2018-05-06")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday; //联系人生日

    public LinkManVo(LinkMan linkMan) {
        this.lid = linkMan.getLid();
        this.name = linkMan.getName();
        this.address = linkMan.getAddress();
        this.phone = linkMan.getPhone();
        this.birthday = linkMan.getBirthday();
    }
}
