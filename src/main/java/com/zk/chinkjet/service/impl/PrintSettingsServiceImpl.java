package com.zk.chinkjet.service.impl;

import java.util.List;

import com.zk.chinkjet.dao.PrintSettingsDao;
import com.zk.chinkjet.entity.PrintSettings;
import com.zk.chinkjet.service.PrintSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2021-02-08
 */
@Service
public class PrintSettingsServiceImpl implements PrintSettingsService
{
    @Autowired
    private PrintSettingsDao PrintSettingsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param zId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public PrintSettings selectPrintSettingsById(String zId)
    {
        return PrintSettingsMapper.selectPrintSettingsById(zId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param PrintSettings 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PrintSettings> selectPrintSettingsList(PrintSettings PrintSettings)
    {
        return PrintSettingsMapper.selectPrintSettingsList(PrintSettings);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param PrintSettings 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPrintSettings(PrintSettings PrintSettings)
    {
        return PrintSettingsMapper.insertPrintSettings(PrintSettings);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param PrintSettings 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePrintSettings(PrintSettings PrintSettings)
    {
        return PrintSettingsMapper.updatePrintSettings(PrintSettings);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePrintSettingsByIds(String ids)
    {
        return PrintSettingsMapper.deletePrintSettingsById(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param zId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePrintSettingsById(String zId)
    {
        return PrintSettingsMapper.deletePrintSettingsById(zId);
    }
}
