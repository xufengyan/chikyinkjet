package com.zk.chinkjet.dao;

import java.util.List;
import com.zk.chinkjet.entity.PrintSettings;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2021-02-08
 */
public interface PrintSettingsDao
{
    /**
     * 查询【请填写功能名称】
     *
     * @param zId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public PrintSettings selectPrintSettingsById(String zId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param PrintSettings 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PrintSettings> selectPrintSettingsList(PrintSettings PrintSettings);

    /**
     * 新增【请填写功能名称】
     *
     * @param PrintSettings 【请填写功能名称】
     * @return 结果
     */
    public int insertPrintSettings(PrintSettings PrintSettings);

    /**
     * 修改【请填写功能名称】
     *
     * @param PrintSettings 【请填写功能名称】
     * @return 结果
     */
    public int updatePrintSettings(PrintSettings PrintSettings);

    /**
     * 删除【请填写功能名称】
     *
     * @param zId 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePrintSettingsById(String zId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param zIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePrintSettingsByIds(String[] zIds);
}
