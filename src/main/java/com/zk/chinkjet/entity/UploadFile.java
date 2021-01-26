package com.zk.chinkjet.entity;

import java.util.Date;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/31 17:02
 */
public class UploadFile {
    private String  zId;
    //文件名
    private String fileName;
    //文件地址
    private String filePath;
    //文件映射地址
    private String mapFilePath;
    //创建时间
    private Date createTime;

    public String getzId() {
        return zId;
    }

    public void setzId(String zId) {
        this.zId = zId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMapFilePath() {
        return mapFilePath;
    }

    public void setMapFilePath(String mapFilePath) {
        this.mapFilePath = mapFilePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
