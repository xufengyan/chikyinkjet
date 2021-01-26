package com.zk.chinkjet.entity;

/**
 * 字体样式
 * @author xf
 * @version 1.0
 * @date 2021/1/6 16:43
 */
public class TextStyle {
    private String fontSize = "20px";
    private String transform= "rotate(0deg) scale(1,1)";
    private String letterSpacing= "1px";
    private String transformOrigin= "left";
    // wordBreak= "keep-all",
    private String whiteSpace="nowrap";
    private String fontWeight= "normal";
    private String fontStyle =  "normal";

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getTransform() {
        return transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public String getLetterSpacing() {
        return letterSpacing;
    }

    public void setLetterSpacing(String letterSpacing) {
        this.letterSpacing = letterSpacing;
    }

    public String getTransformOrigin() {
        return transformOrigin;
    }

    public void setTransformOrigin(String transformOrigin) {
        this.transformOrigin = transformOrigin;
    }

    public String getWhiteSpace() {
        return whiteSpace;
    }

    public void setWhiteSpace(String whiteSpace) {
        this.whiteSpace = whiteSpace;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }
}
