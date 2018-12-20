package com.chimm.cms.linkman.controller;

import com.chimm.cms.domain.PageResult;
import com.chimm.cms.domain.linkman.LinkMan;
import com.chimm.cms.linkman.service.LinkManService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by huangs on 2018/12/20 0020.
 *
 * 联系人模块Controller
 */
@RestController
@RequestMapping("/linkman")
@Api(tags = "联系人模块相关接口")
public class LinkManController {

    @Autowired
    private LinkManService linkManService;

    /**
     * 分页查询联系人列表
     * @param page 当前页（起始1）
     * @param size 一页显示数
     * @return PageResult
     */
    @ApiOperation(value = "分页查询联系人列表",notes = "page传参起始页数为1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页数",paramType = "query",example = "1"),
            @ApiImplicitParam(name = "size",value = "一页显示数",paramType = "query",example = "10")
    })
    @GetMapping("/findAll")
    public PageResult<LinkMan> findAllByPage(int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        return linkManService.findAllByPage(page, size);
    }
}
