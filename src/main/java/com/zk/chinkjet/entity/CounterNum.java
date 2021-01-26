package com.zk.chinkjet.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 计数器内容
 * @author xf
 * @version 1.0
 * @date 2021/1/7 9:22
 */
public class CounterNum {

    private String zId;

    //进制
    private Integer system= 10 ;//16:十六进制 10：十进制 8:进制
    //初始值
    private Integer initVal= 0;
    //宽度，高位补0，留下多少个0 ，最小根据进制，最大16
    private Integer width= 9;
    //进步
    private Integer progress= 1;
    //最小值
    private Integer minVal=0;
    //最大值
    private Integer maxVal= 999999999;
    //重复
    private Integer repetition= 1;
    //是否高位补0
    private Boolean highOrder= true;

    public String getzId() {
        return zId;
    }

    public void setzId(String zId) {
        this.zId = zId;
    }


    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public Integer getInitVal() {
        return initVal;
    }

    public void setInitVal(Integer initVal) {
        this.initVal = initVal;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getMinVal() {
        return minVal;
    }

    public void setMinVal(Integer minVal) {
        this.minVal = minVal;
    }

    public Integer getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Integer maxVal) {
        this.maxVal = maxVal;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

    public Boolean getHighOrder() {
        return highOrder;
    }

    public void setHighOrder(Boolean highOrder) {
        this.highOrder = highOrder;
    }
}
