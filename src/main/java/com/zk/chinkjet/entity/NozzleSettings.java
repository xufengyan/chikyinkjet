package com.zk.chinkjet.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 【请填写功能名称】对象 zk_nozzle_settings
 *
 * @author ruoyi
 * @date 2021-02-08
 */
public class NozzleSettings
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String zId;

    /** $column.columnComment */
    private String uId;

    /** 喷头电压 */
    private String nozzleVoltage;

    /** 闪喷时间 */
    private String flashsprayTime;

    /** 喷墨浓度 */
    private Long printDarkness;

    /** DPI */
    private Long dpi;

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
    public void setNozzleVoltage(String nozzleVoltage)
    {
        this.nozzleVoltage = nozzleVoltage;
    }

    public String getNozzleVoltage()
    {
        return nozzleVoltage;
    }
    public void setFlashsprayTime(String flashsprayTime)
    {
        this.flashsprayTime = flashsprayTime;
    }

    public String getFlashsprayTime()
    {
        return flashsprayTime;
    }
    public void setPrintDarkness(Long printDarkness)
    {
        this.printDarkness = printDarkness;
    }

    public Long getPrintDarkness()
    {
        return printDarkness;
    }
    public void setDpi(Long dpi)
    {
        this.dpi = dpi;
    }

    public Long getDpi()
    {
        return dpi;
    }

}
