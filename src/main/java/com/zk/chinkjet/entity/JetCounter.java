package com.zk.chinkjet.entity;

import java.util.Date;
import java.util.List;

/**
 * 字体样式
 * @author xf
 * @version 1.0
 * @date 2021/1/6 16:14
 */
public class JetCounter {
    private String zId;

    private String rId;
    //内容
    private String textVal;
    //拖拽位置
    private Integer x;

    private Integer y;
    //旋转角度
    private Integer rotate;
    //比例
    private Integer scale;
    //字体大小
    private Integer fontSize;
    //字间隙
    private Integer letterSpacing;
    //粗体
    private Boolean fontWeight;
    //斜体
    private Boolean fontStyle;
    //内容类型：text文本，img图片，counterNum计数器，date时间，QRCode二维码
    private String dragType;
    //时间内容时，选择是date 是 日期格式2020-02-12，time是时间格式13=20=00
    private String mode;
    //时间内容时，选择的时间格式的什么
    private Integer dateFormat;

    private Date originalDate;
    //图片地址
    private String imageSrc;
    //图片原始宽度
    private String originWidth;
    //图片原始高度
    private String originHtight;

    //计数器设置
    private CounterNum setCounterNum;
    //二维码设置
    private QRCode setQRCode;
    //字体样式
    private TextStyle style;
    //图片设置
    private Image imgStyle;

    private String excelArr;

    private String postpone;

    private Integer postponeVal;

    public String getExcelArr() {
        return excelArr;
    }

    public void setExcelArr(String excelArr) {
        this.excelArr = excelArr;
    }

    public String getPostpone() {
        return postpone;
    }

    public void setPostpone(String postpone) {
        this.postpone = postpone;
    }

    public Integer getPostponeVal() {
        return postponeVal;
    }

    public void setPostponeVal(Integer postponeVal) {
        this.postponeVal = postponeVal;
    }

    public Date getOriginalDate() {
        return originalDate;
    }

    public void setOriginalDate(Date originalDate) {
        this.originalDate = originalDate;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getTextVal() {
        return textVal;
    }

    public void setTextVal(String textVal) {
        this.textVal = textVal;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getRotate() {
        return rotate;
    }

    public String getzId() {
        return zId;
    }

    public void setzId(String zId) {
        this.zId = zId;
    }

    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getLetterSpacing() {
        return letterSpacing;
    }

    public void setLetterSpacing(Integer letterSpacing) {
        this.letterSpacing = letterSpacing;
    }

    public Boolean getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(Boolean fontWeight) {
        this.fontWeight = fontWeight;
    }

    public Boolean getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(Boolean fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getDragType() {
        return dragType;
    }

    public void setDragType(String dragType) {
        this.dragType = dragType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(Integer dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getOriginWidth() {
        return originWidth;
    }

    public void setOriginWidth(String originWidth) {
        this.originWidth = originWidth;
    }

    public String getOriginHtight() {
        return originHtight;
    }

    public void setOriginHtight(String originHtight) {
        this.originHtight = originHtight;
    }

    public CounterNum getSetCounterNum() {
        return setCounterNum;
    }

    public void setSetCounterNum(CounterNum setCounterNum) {
        this.setCounterNum = setCounterNum;
    }

    public QRCode getSetQRCode() {
        return setQRCode;
    }

    public void setSetQRCode(QRCode setQRCode) {
        this.setQRCode = setQRCode;
    }

    public TextStyle getStyle() {
        return style;
    }

    public void setStyle(TextStyle style) {
        this.style = style;
    }

    public Image getImgStyle() {
        return imgStyle;
    }

    public void setImgStyle(Image imgStyle) {
        this.imgStyle = imgStyle;
    }
}
