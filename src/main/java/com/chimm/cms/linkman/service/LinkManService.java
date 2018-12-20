package com.chimm.cms.linkman.service;

import com.chimm.cms.domain.PageResult;
import com.chimm.cms.domain.linkman.LinkMan;
import com.chimm.cms.linkman.dao.LinkManDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //分页查询
        Pageable pageable = new PageRequest(page-1,size);
        Page<LinkMan> linkManPage = linkManDao.findAll(pageable);

        //封装结果集并返回
        PageResult<LinkMan> pageResult = new PageResult(linkManPage.getTotalElements(),page,linkManPage.getTotalPages(),linkManPage.getContent());
        return pageResult;
    }
}
