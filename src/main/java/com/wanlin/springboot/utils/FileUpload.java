package com.wanlin.springboot.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传类
 * Created by kangwl_pc on 2018/1/18.
 */
@RestController
@RequestMapping("fileUpload")
public class FileUpload {

    @RequestMapping("/fileUploadTest1")
    public Map<String,Object> uploadFile1(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<String,Object>();
        System.out.println("=============文件上传开始=================");
        result.put("begin","文件上传开始");
        MultipartHttpServletRequest requestFile = null;
        try{
            requestFile = (MultipartHttpServletRequest)request;
        }catch(ClassCastException e){
            System.out.println("=============没有获取到文件=================");
            result.put("meg","没有获取到文件");
        }
        if(null != requestFile){
            List<MultipartFile> files = requestFile.getFiles("file");
            if(files.size()>0){
                for(int i=0;i<files.size();i++){
                    result.put("file"+i,((MultipartFile)files.get(i)).getOriginalFilename());
                }
            }
        }
        result.put("ending","文件上传结束");
        System.out.println(result);
        return result;
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("============进入初始方法===========");
        return "testPage";
    }

}
