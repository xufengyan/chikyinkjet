package com.zk.chinkjet.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/3 15:03
 */
@Controller
public class test {

    @RequestMapping("/test.html")
    public String testHtml(){
        return "dragHtml/index";
    }
    @RequestMapping("/test2.html")
    public String testHtml2(){
        return "dragHtml/index2";
    }
}
