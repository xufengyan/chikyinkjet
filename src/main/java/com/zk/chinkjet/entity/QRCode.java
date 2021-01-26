package com.zk.chinkjet.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 二维码内容
 * @author xf
 * @version 1.0
 * @date 2021/1/6 11:39
 *
 */
public class QRCode {
    private String zId;
    @JSONField(name="QCText")
    private String QCText;
    @JSONField(name="QRCodeType")
    private String QRCodeType;
    @JSONField(name="QCTextType")
    private Boolean QCTextType;
    @JSONField(name="QCWidth")
    private String QCWidth;
    @JSONField(name="QCHeight")
    private String QCHeight;
    private String fileId;
    private String setVariableQRCode;

    public String getSetVariableQRCode() {
        return setVariableQRCode;
    }

    public void setSetVariableQRCode(String setVariableQRCode) {
        this.setVariableQRCode = setVariableQRCode;
    }

    public String getzId() {
        return zId;
    }

    public void setzId(String zId) {
        this.zId = zId;
    }

    public String getQCText() {
        return QCText;
    }

    public void setQCText(String QCText) {
        this.QCText = QCText;
    }

    public String getQRCodeType() {
        return QRCodeType;
    }

    public void setQRCodeType(String QRCodeType) {
        this.QRCodeType = QRCodeType;
    }

    public Boolean getQCTextType() {
        return QCTextType;
    }

    public void setQCTextType(Boolean QCTextType) {
        this.QCTextType = QCTextType;
    }

    public String getQCWidth() {
        return QCWidth;
    }

    public void setQCWidth(String QCWidth) {
        this.QCWidth = QCWidth;
    }

    public String getQCHeight() {
        return QCHeight;
    }

    public void setQCHeight(String QCHeight) {
        this.QCHeight = QCHeight;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
