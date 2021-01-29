package com.zk.chinkjet.service.impl;

import com.zk.chinkjet.dao.RecordsDao;
import com.zk.chinkjet.entity.JetCounter;
import com.zk.chinkjet.entity.Records;
import com.zk.chinkjet.service.RecordsService;
import com.zk.chinkjet.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
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
        List<JetCounter> delJet = new ArrayList<>();
        List<JetCounter> insertJet = new ArrayList<>();
        List<JetCounter> updataJet = new ArrayList<>();
        for (JetCounter jetCounter : records.getJetCounters()) {
            JetCounter j = jetCounter;
            if(j.getDelType()){
                j.setrId(records.getzId());
                delJet.add(j);
            }else if(null == j.getzId()||"".equals(j.getzId())) {
                j.setzId(Tool.CreateID());
                j.setrId(records.getzId());
                insertJet.add(j);
            }else {
                updataJet.add(j);
            }
        }
        int r = 0;
        if (insertJet.size()>0){
            recordsDao.insertJetCounter(insertJet);
        }
        if (delJet.size() > 0) {
            recordsDao.delJetCounter(delJet);
        }
        if(updataJet.size()>0){
            records.setJetCounters(updataJet);
            r = recordsDao.updataRecords(records);
        }
        return r;
    }

    @Override
    public int deleteRecords(String rId) {
        return recordsDao.delRecords(rId);
    }
}
