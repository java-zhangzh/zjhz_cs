package com.zjhz.gismap.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 12947 on 2019/6/9.
 */
public class Test {

    public static void main(String []arge){
//
//        Map<String, Object> freeMarkerMap = new HashMap<>();
//
//        KgModel kgModel=new KgModel();
//        kgModel.setImg("asdf");
//        kgModel.setLogo("asdfddddddddddd");
//        kgModel.setQrCode("asdf");
//        kgModel.setText("asdfasdf");
//        String targetFile="test.tpl";
//        String newFileName="E:/templates//test.java";
//        freeMarkerMap.put("kgInfo",kgModel);
//        Configuration cfg=new Configuration();
//        Writer out =null;
//        try {
//            cfg.setDirectoryForTemplateLoading(new File("E://templates"));
//            cfg.setObjectWrapper(new DefaultObjectWrapper());
//            cfg.setDefaultEncoding("UTF-8");
//            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
//            Template temp = cfg.getTemplate(targetFile);
//            FileUtil.mkdir(newFileName);
//            out = new OutputStreamWriter(new FileOutputStream(newFileName));
//            temp.process(freeMarkerMap,out);
//            out.flush();
//            out.close();
//
//        }catch (Exception e){
//            System.out.println(e.fillInStackTrace());
//        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日 HH:mm");
        System.out.print(simpleDateFormat.format(new Date()));
    }
}
