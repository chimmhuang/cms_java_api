package com.chimm.cms.linkman.dao;

import com.chimm.cms.domain.linkman.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Created by huangs on 2018/12/20 0020.
 */
public interface LinkManDao extends JpaRepository<LinkMan,String>, JpaSpecificationExecutor<LinkMan>, PagingAndSortingRepository<LinkMan,String> {
}
