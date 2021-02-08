package com.zk.chinkjet.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 【请填写功能名称】对象 zk_print_settings
 *
 * @author ruoyi
 * @date 2021-02-08
 */
public class PrintSettings
{
    private static final long serialVersionUID = 1L;

    /** 按键音 */
    private String zId;

    /** $column.columnComment */
    private String uId;

    /** $column.columnComment */
    private Integer keyBeep;

    /** 打印音 */
    private Integer printBeep;

    /** 上下翻转 */
    private Integer tbrev;

    /** 反向打印 */
    private Integer lrrev;

    /** 同步方式 */
    private String syncMode;

    /** 同步方式下标 */
    private Integer syncModeIndex;

    /** 同步字宽 */
    private Long syncWordWidth;

    /** 开始信号 */
    private String startSignal;

    /** 开始信号下标 */
    private Integer startSignalIndex;

    /** 打印次数 */
    private Long printTimes;

    /** 重复打印 */
    private Integer repeatPrint;

    /** 重复次数 */
    private Long repeatTimes;

    /** 重复延迟 */
    private String repeatDelay;

    public void setzId(String zId)
    {
        this.zId = zId;
    }

    public String getzId()
    {
        return zId;
    }
    public void setuId(String uId)
    {
        this.uId = uId;
    }

    public String getuId()
    {
        return uId;
    }
    public void setKeyBeep(Integer keyBeep)
    {
        this.keyBeep = keyBeep;
    }

    public Integer getKeyBeep()
    {
        return keyBeep;
    }
    public void setPrintBeep(Integer printBeep)
    {
        this.printBeep = printBeep;
    }

    public Integer getPrintBeep()
    {
        return printBeep;
    }
    public void setTbrev(Integer tbrev)
    {
        this.tbrev = tbrev;
    }

    public Integer getTbrev()
    {
        return tbrev;
    }
    public void setLrrev(Integer lrrev)
    {
        this.lrrev = lrrev;
    }

    public Integer getLrrev()
    {
        return lrrev;
    }
    public void setSyncMode(String syncMode)
    {
        this.syncMode = syncMode;
    }

    public String getSyncMode()
    {
        return syncMode;
    }
    public void setSyncModeIndex(Integer syncModeIndex)
    {
        this.syncModeIndex = syncModeIndex;
    }

    public Integer getSyncModeIndex()
    {
        return syncModeIndex;
    }
    public void setSyncWordWidth(Long syncWordWidth)
    {
        this.syncWordWidth = syncWordWidth;
    }

    public Long getSyncWordWidth()
    {
        return syncWordWidth;
    }
    public void setStartSignal(String startSignal)
    {
        this.startSignal = startSignal;
    }

    public String getStartSignal()
    {
        return startSignal;
    }
    public void setStartSignalIndex(Integer startSignalIndex)
    {
        this.startSignalIndex = startSignalIndex;
    }

    public Integer getStartSignalIndex()
    {
        return startSignalIndex;
    }
    public void setPrintTimes(Long printTimes)
    {
        this.printTimes = printTimes;
    }

    public Long getPrintTimes()
    {
        return printTimes;
    }
    public void setRepeatPrint(Integer repeatPrint)
    {
        this.repeatPrint = repeatPrint;
    }

    public Integer getRepeatPrint()
    {
        return repeatPrint;
    }
    public void setRepeatTimes(Long repeatTimes)
    {
        this.repeatTimes = repeatTimes;
    }

    public Long getRepeatTimes()
    {
        return repeatTimes;
    }
    public void setRepeatDelay(String repeatDelay)
    {
        this.repeatDelay = repeatDelay;
    }

    public String getRepeatDelay()
    {
        return repeatDelay;
    }

}
