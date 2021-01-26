package com.zk.chinkjet.entity;

import java.util.Date;
import java.util.List;

/**
 * 记录表（保存用户之前打印过的内容）
 * @author xf
 * @version 1.0
 * @date 2021/1/7 17:37
 */
public class Records {

    private String zId;
    //记录名称
    private String rName;
    //用户Id
    private String rUserId;
    //创建时间
    private Date createTime;
    //打印内容
    private List<JetCounter> jetCounters;

    public String getzId() {
        return zId;
    }

    public void setzId(String zId) {
        this.zId = zId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrUserId() {
        return rUserId;
    }

    public void setrUserId(String rUserId) {
        this.rUserId = rUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<JetCounter> getJetCounters() {
        return jetCounters;
    }

    public void setJetCounters(List<JetCounter> jetCounters) {
        this.jetCounters = jetCounters;
    }
}
