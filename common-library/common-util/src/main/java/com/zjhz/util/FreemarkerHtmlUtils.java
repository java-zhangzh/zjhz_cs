package com.zjhz.util;

import com.zjhz.base.constants.Constant;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.boot.system.ApplicationHome;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 12947 on 2019/6/10.
 */
public class FreemarkerHtmlUtils {

    public static void main(String [] args){


       Map<String, Object> freeMarkerMap = new HashMap<>();
        //通过数据库查找幼儿园简介数据封装到实体
          /*   KgModel kgModel=new KgModel();
            kgModel.setImg("http://test.png");
            kgModel.setLogo("http://logo.png");
            kgModel.setQrCode("http://erweima.png");
            kgModel.setText("幼儿园简介信息dsfaaaaaaa");
            freeMarkerMap.put("kgInfo",kgModel);*/




             generateHtmlUrl(freeMarkerMap,"test",Constant.OBS_TEMPLATE_DIC_ADDRESS,Constant.OBS_TEMPLATE_NAME);
      //  UploadOBS.deleteOBS("c0e31efb-9d4d-470d-ac36-b60af407af40.6176630162784956.html");
       // UploadOBS.deleteOBS("eb5a8777-34b2-4ae0-af06-5e1a89c1db45.16337921407861744.html");
        //UploadOBS.deleteOBS("c0e31efb-9d4d-470d-ac36-b60af407af40.6176630162784956.html");

    }
    /**
    * <b>方法名：</b><br>
    * <b>说明：</b> <br>
    * @param freeMarkerMap 数据封装
    	 * @param fileName  自定义文件名称
    	 * @param templatePath 模板目录 如：E:/teamplate
    	 * @param templateName  模板名称 如：test.html
    * @return java.lang.String 返回url地址
    * <b>生成html文件：</b>
    *
    * @author 2019/6/10   zhangzh
    */

    public static String generateHtmlUrl(Map<String, Object> freeMarkerMap, String fileName,String templatePath,String templateName) {

        String resultUrl="";
        String templateFolderDirectory = templatePath;//模板文件目录
        String targetFile =templateName; //模板名称
        Configuration cfg = new Configuration();
        StringWriter out = new StringWriter();
        try {

            ApplicationHome home = new ApplicationHome(new FreemarkerHtmlUtils().getClass());
            File jarFile = home.getSource();
            String path =  jarFile.getParentFile().getPath();

            cfg.setDirectoryForTemplateLoading(new File(path + "/html/"));
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
            Template temp = cfg.getTemplate(targetFile);
            temp.process(freeMarkerMap, out);

            out.flush();
            resultUrl= out.toString();
            out.close();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        return resultUrl;
    }

}
