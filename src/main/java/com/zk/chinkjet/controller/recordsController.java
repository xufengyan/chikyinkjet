package com.zk.chinkjet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zk.chinkjet.entity.JetCounter;
import com.zk.chinkjet.entity.Records;
import com.zk.chinkjet.service.RecordsService;
import com.zk.chinkjet.util.Enum.ResultEnum;
import com.zk.chinkjet.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author xf
 * @version 1.0
 * @date 2021/1/8 14:53
 */
@CrossOrigin
@Controller
@RequestMapping("records")
public class recordsController {
    @Autowired
    private RecordsService recordsService;

    /**
     * 查询打印内容记录
     */
    @RequestMapping("getRecordsList")
    @ResponseBody
    public Result getRecordsList(String user){
        Records records = new Records();
        records.setrUserId("1");
        List<Records> recordsList = recordsService.getRecordsList(records);
        for (Records r : recordsList) {
            Iterator iterator =  r.getJetCounters().iterator();
            while (iterator.hasNext()){
                JetCounter j = (JetCounter) iterator.next();
                if (j.getzId()==null){
                    iterator.remove();
                }
            }
        }

        Result result = new Result(ResultEnum.OK,JSON.toJSONString(recordsList),true);
        return result;
    }


    /**
     * 添加打印记录
     * @param recordsStr
     * @param rName
     */
    @RequestMapping(value = "addRecords",method = RequestMethod.POST)
    @ResponseBody
    public Result addRecords(String recordsStr,String rName){

        Records records = new Records();
//        records.setCreateTime(new Date());
        //将json字符串转换为对象集合
        List<JetCounter> JetCounters = JSON.parseArray(recordsStr,JetCounter.class);
        records.setJetCounters(JetCounters);
        records.setrName(rName);
        int r = recordsService.insertRecords(records);
        Result result = new Result(ResultEnum.OK);
        System.out.println("s");
        return result;
    }

    /**
     * 修改
     * @param recordsStr
     * @param rName
     */
    @RequestMapping("updateRecords")
    @ResponseBody
    public Result updateRecords(String recordsStr,String rName,String zId){
        List<JetCounter> JetCounters = JSON.parseArray(recordsStr,JetCounter.class);
        Records records = new Records();
        records.setzId(zId);
        records.setJetCounters(JetCounters);
        records.setrUserId("1");
        records.setrName(rName);
        int r = recordsService.updataRecords(records);
        Result result = new Result(ResultEnum.OK);
        return result;
    }

    /**
     * 删除记录
     * @param rId
     * @return
     */
    @RequestMapping("deleteRecords")
    @ResponseBody
    public Result deleteRecords(String rId){

        Result result = new Result(ResultEnum.OK);
        return result;
    }


}

