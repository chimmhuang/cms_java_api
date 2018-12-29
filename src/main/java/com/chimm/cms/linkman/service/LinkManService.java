package com.chimm.cms.linkman.service;

import com.chimm.cms.base.domain.response.ResponseResult;
import com.chimm.cms.domain.PageResult;
import com.chimm.cms.domain.linkman.LinkMan;
import com.chimm.cms.domain.linkman.response.LinkmanResult;
import com.chimm.cms.linkman.dao.LinkManDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.chimm.cms.base.domain.response.CommonCode;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Created by huangs on 2018/12/20 0020.
 *
 * 联系人模块service层
 */
@Service
public class LinkManService {

    @Autowired
    private LinkManDao linkManDao;

    /**
     * 分页查询联系人列表
     * @param page 当前页（起始1）
     * @param size 一页显示数
     * @return PageResult
     */
    public PageResult<LinkMan> findAllByPage(int page, int size) {
        //分页查询 - 根据更新时间降序
        Sort sort = new Sort(Sort.Direction.DESC,"updateTime");
        Pageable pageable = new PageRequest(page-1,size,sort);
        Page<LinkMan> linkManPage = linkManDao.findAll(pageable);

        //封装结果集并返回
        PageResult<LinkMan> pageResult = new PageResult(linkManPage.getTotalElements(),page,linkManPage.getTotalPages(),linkManPage.getContent());
        return pageResult;
    }


    /**
     * 保存/修改联系人信息到数据库
     * @param linkMan 联系人实体类
     * @return ResponseResult
     */
    public LinkmanResult saveLinkman(LinkMan linkMan) {
        if (linkMan == null) {
            return new LinkmanResult(CommonCode.FAIL,null);
        }

        // 判断是更新还是新增操作
        if (StringUtils.isEmpty(linkMan.getLid())) {
            //新增
            linkMan.setCreateTime(new Date());
            linkMan.setUpdateTime(new Date());
        } else {
            //更新
            Optional<LinkMan> optional = linkManDao.findById(linkMan.getLid());
            if (optional.isPresent()) {
                linkMan = optional.get();
                linkMan.setUpdateTime(new Date());
            }
        }

        LinkMan linkMan1 = linkManDao.save(linkMan);

        return new LinkmanResult(CommonCode.SUCCESS,linkMan1);
    }


    /**
     * 根据id查询联系人信息
     * @param lid 联系人id
     * @return LinkMan/null
     */
    public LinkMan findById(String lid) {
        Optional<LinkMan> optional = linkManDao.findById(lid);
        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    /**
     * 通过id删除对应的联系人信息
     * @param lid 联系人id
     * @return ResponseResult
     */
    public ResponseResult delById(String lid) {
        Optional<LinkMan> optional = linkManDao.findById(lid);
        if (optional.isPresent()) {
            linkManDao.deleteById(lid);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
