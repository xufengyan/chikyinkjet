package com.zk.chinkjet.service;

import com.zk.chinkjet.entity.PrintSettings;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2021-02-08
 */
public interface PrintSettingsService
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
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePrintSettingsByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param zId 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePrintSettingsById(String zId);
}
