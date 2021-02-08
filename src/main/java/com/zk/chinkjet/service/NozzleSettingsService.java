package com.zk.chinkjet.service;

import com.zk.chinkjet.entity.NozzleSettings;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2021-02-08
 */
public interface NozzleSettingsService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param zId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public NozzleSettings selectNozzleSettingsById(String zId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param NozzleSettings 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<NozzleSettings> selectNozzleSettingsList(NozzleSettings NozzleSettings);

    /**
     * 新增【请填写功能名称】
     *
     * @param NozzleSettings 【请填写功能名称】
     * @return 结果
     */
    public int insertNozzleSettings(NozzleSettings NozzleSettings);

    /**
     * 修改【请填写功能名称】
     *
     * @param NozzleSettings 【请填写功能名称】
     * @return 结果
     */
    public int updateNozzleSettings(NozzleSettings NozzleSettings);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNozzleSettingsByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param zId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteNozzleSettingsById(String zId);
}
