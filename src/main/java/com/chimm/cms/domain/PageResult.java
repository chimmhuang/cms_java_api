package com.chimm.cms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Created by huangs on 2018/12/20 0020.
 */
@Data
@ToString
@NoArgsConstructor
@ApiModel("分页结果集对象")
public class PageResult<T> implements Serializable {

    @ApiModelProperty(name = "total",value = "总记录数",example = "20")
    private Long total; //总记录数

    @ApiModelProperty(name = "page",value = "当前页",example = "1")
    private int page; //当前页

    @ApiModelProperty(name = "totalPage",value = "总页数",example = "50")
    private int totalPage; //总页数

    @ApiModelProperty(name = "rows",value = "结果集")
    private List<T> rows; //查询结果


    public PageResult(Long total, int page, int totalPage,List<T> rows) {
        this.total = total;
        this.page = page;
        this.totalPage = totalPage;
        this.rows = rows;
    }
}
