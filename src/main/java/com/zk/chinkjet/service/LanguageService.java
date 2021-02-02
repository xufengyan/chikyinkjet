package com.zk.chinkjet.service;

import com.zk.chinkjet.entity.Language;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2021-01-29
 */
public interface LanguageService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param stringId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Language selectLanguageById(String stringId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param Language 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Language> selectLanguageList(Language Language);

    /**
     * 新增【请填写功能名称】
     *
     * @param Language 【请填写功能名称】
     * @return 结果
     */
    public int insertLanguage(Language Language);

    /**
     * 修改【请填写功能名称】
     *
     * @param Language 【请填写功能名称】
     * @return 结果
     */
    public int updateLanguage(Language Language);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLanguageByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param stringId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteLanguageById(String stringId);
}
