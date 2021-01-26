package com.zk.chinkjet.service;

import com.zk.chinkjet.entity.Records;

import java.util.List;

/**
 * @author xf
 * @version 1.0
 * @date 2021/1/8 14:52
 */
public interface RecordsService {
    //查询打印内容
    public List<Records> getRecordsList(Records records);

    //添加打印内容
    int insertRecords(Records records);
//    int inserJetContent(JetContent jetContent);
    //修改打印内容
    int updataRecords(Records records);

    //删除打印内容
    int deleteRecords(String rId);
}
