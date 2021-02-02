package com.zk.chinkjet.service.impl;

import java.util.List;

import com.zk.chinkjet.dao.LanguageDao;
import com.zk.chinkjet.entity.Language;
import com.zk.chinkjet.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-29
 */
@Service
public class LanguageServiceImpl implements LanguageService
{
    @Autowired
    private LanguageDao LanguageMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param stringId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Language selectLanguageById(String stringId)
    {
        return LanguageMapper.selectLanguageById(stringId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param Language 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Language> selectLanguageList(Language Language)
    {
        return LanguageMapper.selectLanguageList(Language);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param Language 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertLanguage(Language Language)
    {
        return LanguageMapper.insertLanguage(Language);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param Language 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateLanguage(Language Language)
    {
        return LanguageMapper.updateLanguage(Language);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLanguageByIds(String ids)
    {
        return LanguageMapper.deleteLanguageById(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param stringId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteLanguageById(String stringId)
    {
        return LanguageMapper.deleteLanguageById(stringId);
    }
}
