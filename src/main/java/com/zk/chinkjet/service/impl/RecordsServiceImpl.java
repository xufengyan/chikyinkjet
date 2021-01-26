package com.zk.chinkjet.service.impl;

import com.zk.chinkjet.dao.RecordsDao;
import com.zk.chinkjet.entity.JetCounter;
import com.zk.chinkjet.entity.Records;
import com.zk.chinkjet.service.RecordsService;
import com.zk.chinkjet.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xf
 * @version 1.0
 * @date 2021/1/8 14:52
 */
@Service
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordsDao recordsDao;
    @Override
    public List<Records> getRecordsList(Records records) {
        return recordsDao.selectRecordsList(records);
    }

    @Override
    public int insertRecords(Records records) {
        records.setCreateTime(new Date());
        records.setrUserId("1");
        records.setzId(Tool.CreateID());
        //添加条数
            for (JetCounter jetContent : records.getJetCounters()) {
                jetContent.setzId(Tool.CreateID());
                jetContent.setrId(records.getzId());

            }
        int r = recordsDao.insertRecords(records);

        return r;
    }

    @Override
    public int updataRecords(Records records) {
        return recordsDao.updataRecords(records);
    }

    @Override
    public int deleteRecords(String rId) {
        return recordsDao.delRecords(rId);
    }
}
