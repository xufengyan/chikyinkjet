package com.zk.chinkjet.controller;

import com.zk.chinkjet.entity.Language;
import com.zk.chinkjet.service.LanguageService;
import com.zk.chinkjet.util.Enum.ResultEnum;
import com.zk.chinkjet.util.Result;
import org.apache.ibatis.annotations.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xf
 * @version 1.0
 * @date 2021/2/1 10:12
 */
@RequestMapping("/language")
@Controller
public class languageController {
    @Autowired
    private LanguageService languageService;
    /**
     * 查询
     * @return
     */
    @RequestMapping("getLanguageList")
    @ResponseBody
    public Result getLanguageList(){
        List<Language> languages = languageService.selectLanguageList(null);
        Result result = new Result(ResultEnum.OK,languages,true);
        return result;
    }
}
