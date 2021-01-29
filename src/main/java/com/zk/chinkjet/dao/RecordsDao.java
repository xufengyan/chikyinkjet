package com.zk.chinkjet.dao;

import com.zk.chinkjet.entity.JetCounter;
import com.zk.chinkjet.entity.Records;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xf
 * @version 1.0
 * @date 2021/1/8 9:14
 */
@Component
public interface RecordsDao {

    List<Records> selectRecordsList(Records records);

    int insertRecords(Records records);

    int insertJetCounter(List<JetCounter> jetCounters);

    int updataRecords(Records records);

    int delRecords(String rId);

    int delJetCounter(List<JetCounter> jetCounters);

}
