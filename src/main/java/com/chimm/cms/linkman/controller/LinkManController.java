package com.chimm.cms.linkman.controller;

import com.chimm.cms.base.domain.response.ResponseResult;
import com.chimm.cms.domain.PageResult;
import com.chimm.cms.domain.linkman.LinkMan;
import com.chimm.cms.domain.linkman.response.LinkmanResult;
import com.chimm.cms.domain.linkman.vo.LinkManVo;
import com.chimm.cms.linkman.service.LinkManService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PageResult<LinkManVo> findAllByPage(int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        return linkManService.findAllByPage(page, size);
    }


    /**
     * 保存/修改 联系人
     * @param linkMan 联系人实体类
     * @return LinkmanResult
     */
    @ApiOperation(value = "保存/修改 联系人",notes = "保存和修改都是一个接口，保存不用传入lid字段，修改必须传入lid字段")
    @PostMapping("/save")
    public LinkmanResult save(@RequestBody @ApiParam(name = "linkMan",value = "新增不需要lid",required = true) LinkMan linkMan) {
        return linkManService.saveLinkman(linkMan);
    }

    /**
     * 根据id查询联系人信息
     * @param lid 联系人id
     * @return LinkMan/null
     */
    @ApiOperation(value = "根据id查询指定联系人信息",notes = "联系人的id是放在请求路径/{path}中")
    @ApiImplicitParam(name = "lid",value = "指定联系人id",paramType = "path",example = "1a3e6dc8225045ab9f0bf4ae56e98bde")
    @GetMapping("/{lid}")
    public LinkManVo findById(@PathVariable("lid") String lid) {
        return linkManService.findById(lid);
    }


    /**
     * 通过id删除对应的联系人信息
     * @param lid 联系人id
     * @return ResponseResult
     */
    @ApiOperation(value = "通过id删除对应的联系人信息",notes = "联系人的id是放在请求路径/{path}中")
    @ApiImplicitParam(name = "lid",value = "指定联系人id",paramType = "path",example = "1a3e6dc8225045ab9f0bf4ae56e98bde")
    @ApiResponses({
            @ApiResponse(code = 10000,message = "删除成功！"),
            @ApiResponse(code = 11111,message = "删除失败！")
    })
    @DeleteMapping("/{lid}")
    public ResponseResult delById(@PathVariable("lid") String lid) {
        return linkManService.delById(lid);
    }


}
