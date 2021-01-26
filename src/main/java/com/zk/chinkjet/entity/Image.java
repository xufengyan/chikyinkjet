package com.zk.chinkjet.entity;

/**
 * @author xf
 * @version 1.0
 * @date 2021/1/7 15:47
 */
public class Image {
    private String zId;

//    private String imageSrc;
    //图片原始宽
//    private Integer originWidth;
    //图片原始高
//    private Integer originHtight;

    //图片显示宽高
    private String width;

    private String height;
    //上传文件id
    private String fileId;


    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
