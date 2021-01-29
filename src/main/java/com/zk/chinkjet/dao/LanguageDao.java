package com.zk.chinkjet.dao;

import java.util.List;
import com.zk.chinkjet.entity.Language;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-29
 */
public interface LanguageDao
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
     * 删除【请填写功能名称】
     *
     * @param stringId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteLanguageById(String stringId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param stringIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLanguageByIds(String[] stringIds);
}
