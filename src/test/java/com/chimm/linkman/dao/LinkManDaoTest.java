package com.chimm.linkman.dao;

import com.chimm.cms.CmsApplication;
import com.chimm.cms.domain.linkman.LinkMan;
import com.chimm.cms.linkman.dao.LinkManDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Created by huangs on 2018/12/20 0020.
 *
 * 联系人模块dao测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmsApplication.class)
public class LinkManDaoTest {

    @Autowired
    private LinkManDao linkManDao;

    /**
     * 批量插入联系人数据
     */
    @Test
    public void insertLinkMan() throws UnsupportedEncodingException {

        Optional<LinkMan> optional = linkManDao.findById("1");
        LinkMan man = optional.get();

        for (int i = 0; i < 40; i++) {
            LinkMan linkMan = new LinkMan();
            String uuid = UUID.randomUUID().toString();

            String[] split = uuid.split("-");
            StringBuilder sb = new StringBuilder();
            for (String str : split) {
                sb.append(str);
            }

            linkMan.setLid(sb.toString());

            linkMan.setName(man.getName()+i);
            linkMan.setAddress(man.getAddress()+i);
            linkMan.setBirthday(new Date());
            linkMan.setPhone("13111111111");

            linkManDao.save(linkMan);
        }
    }
}
