package com.zk.chinkjet.controller;

import com.alibaba.fastjson.JSON;
import com.zk.chinkjet.entity.JetCounter;
import com.zk.chinkjet.entity.QRCode;
import com.zk.chinkjet.entity.UploadFile;
import com.zk.chinkjet.service.FileService;
import com.zk.chinkjet.util.Enum.ResultEnum;
import com.zk.chinkjet.util.MonochromeImage;
import com.zk.chinkjet.util.QRCodeExport;
import com.zk.chinkjet.util.Result;
import com.zk.chinkjet.util.Tool;
import com.zk.chinkjet.util.excel.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.support.SqlValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/31 11:23
 */
@CrossOrigin
@Controller
@RequestMapping("image")
public class imageController {

    @Value("${com.zk.chikyjet.basePath}")
    private String basePath;

    @Value("${com.zk.chikyjet.targetPath}")
    private String targetPath;

    @Value("${com.zk.chikyjet.servicePath}")
    private String servicePath;


    @Autowired
    private FileService fileService;

//    @PostMapping( value = "imageUploadFile",headers = "content-type=multipart/form-data")

    /**
     * 上传图片生成单色位图片
     * @param file
     * @return 返回单色片图片地址
     * @throws IOException
     */
    @RequestMapping("imageUploadFile")
    @ResponseBody
    public UploadFile imageUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            System.out.println("文件为空");
            return null;
        }
        //将图片转换为单色位图片，返回文件地址给前端
        File newFile = MonochromeImage.setMonchromeImage(file.getInputStream(),basePath);
        String [] pathArr = newFile.getPath().split("\\\\");
        UploadFile uploadFile = new UploadFile();
        uploadFile.setzId(Tool.CreateID());
        uploadFile.setCreateTime(new Date());
        uploadFile.setFileName(file.getOriginalFilename());
        uploadFile.setFilePath(newFile.getPath());
        targetPath = targetPath.replace("**","");
        uploadFile.setMapFilePath(servicePath+targetPath+pathArr[pathArr.length-3]+"/"+pathArr[pathArr.length-2]+"/"+pathArr[pathArr.length-1]);
        int n = fileService.addFile(uploadFile);
        return uploadFile;
    }


    /**
     * 获取生成二维码信息
     * @param qrCode
     * @return 返回生成的二维码地址
     */
    @RequestMapping("getQRCode")
    @ResponseBody
    public UploadFile getQRCode(QRCode qrCode){
        String qcPath = QRCodeExport.createQRCode(qrCode.getQCText(),basePath,qrCode.getQRCodeType());
        String [] pathArr = qcPath.split("/");
        UploadFile uploadFile = new UploadFile();
        uploadFile.setzId(Tool.CreateID());
        uploadFile.setCreateTime(new Date());
        uploadFile.setFileName(pathArr[pathArr.length-1]);
        uploadFile.setFilePath(qcPath);
        targetPath = targetPath.replace("**","");
        uploadFile.setMapFilePath(servicePath+targetPath+"QRCode/"+pathArr[pathArr.length-2]+"/"+pathArr[pathArr.length-1]);
        int n = fileService.addFile(uploadFile);
        System.out.println("s");
        return uploadFile;
    }


    /**
     * 上传Excel文件，
     * @param file
     * @return
     */
    @RequestMapping("uploadExcel")
    @ResponseBody
    public Result uploadExcel(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        Result result = null;
        List<String> res = new ArrayList<>();
        try {
            File newfile = File.createTempFile(System.currentTimeMillis() + "", suffix);
            file.transferTo(newfile);
//            List excelList = new ArrayList<>();
            if(suffix.equals(".csv")){
               List excelList = ReadExcel.importCsv(newfile);
               res  = excelList;
               System.out.println("s");
            }else {
                List<List> excelList = ReadExcel.readExcel(newfile);
                for (List o : excelList) {
                    o = (List) o;
                    if (o.size() == 1) {
                        res.add("" + o.get(0));
                    } else {
                        result = new Result(ResultEnum.EXCEL_ERROR, false);
                        return result;
                    }
                }
            }
//            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = new Result(ResultEnum.OK,res,true);
        return result;
    }


    /**
     * 生成可变二维码
     * @param variable
     * @return
     */
    @RequestMapping("getVariableQRCode")
    @ResponseBody
    public Result getVariableQRCode(String variable){

        Map variableQC = JSON.parseObject(variable, Map.class);

        List<Map> contentMap = (List<Map>) variableQC.get("variable");
        String text = "";
        for (Map map : contentMap) {
            if(!"空白".equals(map.get("contentType"))){
                if ("文本".equals(map.get("contentType")) || "日期".equals(map.get("contentType")) ||"计数器".equals(map.get("contentType")) || "表格".equals(map.get("contentType"))){
                    text+=map.get("content");
                }else if ("换行".equals(map.get("contentType"))){
                    text += "\r\n";
                }
            }
        }
        System.out.println(text);
        String qcPath = QRCodeExport.createQRCode(text,basePath, (String) variableQC.get("QRCodeType"));
        String [] pathArr = qcPath.split("/");
        UploadFile uploadFile = new UploadFile();
        uploadFile.setzId(Tool.CreateID());
        uploadFile.setCreateTime(new Date());
        uploadFile.setFileName(pathArr[pathArr.length-1]);
        uploadFile.setFilePath(qcPath);
        targetPath = targetPath.replace("**","");
        uploadFile.setMapFilePath(servicePath+targetPath+"QRCode/"+pathArr[pathArr.length-2]+"/"+pathArr[pathArr.length-1]);
        int n = fileService.addFile(uploadFile);
        Result result = new Result(ResultEnum.OK,uploadFile,true);
        return result;
    }
}
