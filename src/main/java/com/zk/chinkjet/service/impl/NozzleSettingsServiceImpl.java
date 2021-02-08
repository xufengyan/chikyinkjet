package com.zk.chinkjet.service.impl;


import com.zk.chinkjet.dao.NozzleSettingDao;
import com.zk.chinkjet.entity.NozzleSettings;
import com.zk.chinkjet.service.NozzleSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2021-02-08
 */
@Service
public class NozzleSettingsServiceImpl implements NozzleSettingsService
{
    @Autowired
    private NozzleSettingDao NozzleSettingsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param zId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public NozzleSettings selectNozzleSettingsById(String zId)
    {
        return NozzleSettingsMapper.selectNozzleSettingsById(zId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param NozzleSettings 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<NozzleSettings> selectNozzleSettingsList(NozzleSettings NozzleSettings)
    {
        return NozzleSettingsMapper.selectNozzleSettingsList(NozzleSettings);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param NozzleSettings 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertNozzleSettings(NozzleSettings NozzleSettings)
    {
        return NozzleSettingsMapper.insertNozzleSettings(NozzleSettings);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param NozzleSettings 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateNozzleSettings(NozzleSettings NozzleSettings)
    {
        return NozzleSettingsMapper.updateNozzleSettings(NozzleSettings);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNozzleSettingsByIds(String ids)
    {
        return NozzleSettingsMapper.deleteNozzleSettingsById(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param zId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteNozzleSettingsById(String zId)
    {
        return NozzleSettingsMapper.deleteNozzleSettingsById(zId);
    }
}
