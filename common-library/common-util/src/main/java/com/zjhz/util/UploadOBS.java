package com.zjhz.util;

import com.obs.services.ObsClient;
import com.obs.services.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * <b>功能名：</b>UploadOBS<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 zjhz  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-05-09 zhangzhonghao
 */
public class UploadOBS {
    private final static String endPoint = "obs.cn-southwest-2.myhuaweicloud.com";
    private final static String ak = "T3IMDO2PHCUOD8JGE2IE";
    private final static String sk = "9sOX5SsbRtZumSLHVmRsblCLk3A9EdTVckhJ2AqH";

    /**
    * <b>方法名：</b>单个文件上传<br>
    * <b>说明：</b> <br>
    * <b>@param </b>[url 域名, multipartFile 文件]<br>
    * <b>@return：</b>cjava.lang.String<br>
    * <b>修改履历：</b>
    *
    * @author 2019/5/9   zhangzhonghao
    */
    public static String upload(String url, MultipartFile multipartFile) throws IOException {
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        String uuid = UUID.randomUUID().toString();
        String name=multipartFile.getOriginalFilename();
        name=name.substring(name.indexOf("."));
        name=name.toLowerCase();
        PutObjectResult headerResponse = obsClient.putObject("obs-huifan", uuid+name,  multipartFile.getInputStream());
        // 关闭obsClient
        try {
            obsClient.close();
        } catch (IOException e) {
        }
        return url +"/"+ headerResponse.getObjectKey();
    }

    /**
    * <b>方法名：</b>传入流<br>
    * <b>说明：</b> <br>
    * @param url
	 * @param inputStream
    * @return java.lang.String
    * <b>修改履历：</b>
    *
    * @author 2019/7/4   zhangzhonghao
    */
    public static String upload(String url, InputStream inputStream) throws IOException {
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        String uuid = UUID.randomUUID().toString();
        String name=".jpg";
        name=name.toLowerCase();
        PutObjectResult headerResponse = obsClient.putObject("obs-huifan", uuid+name, inputStream);
        // 关闭obsClient
        try {
            obsClient.close();
        } catch (IOException e) {
        }
        return url +"/"+ headerResponse.getObjectKey();
    }
    /**
     * <b>方法名：</b>传入流<br>
     * <b>说明：</b> <br>
     * @param url
     * @param inputStream
     * @return java.lang.String
     * <b>修改履历：</b>
     *
     * @author 2019/7/13   nxs
     */
    public static String upload(String url, String type, InputStream inputStream) throws IOException {
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        String uuid = UUID.randomUUID().toString();
        String name="."+type;
        name=name.toLowerCase();
        PutObjectResult headerResponse = obsClient.putObject("obs-huifan", uuid+name, inputStream);
        // 关闭obsClient
        try {
            obsClient.close();
        } catch (IOException e) {
        }
        return url +"/"+ headerResponse.getObjectKey();
    }

    /**
    * <b>方法名：</b>批量文件上传<br>
    * <b>说明：</b> <br>
    * <b>@param </b>[url 域名, multipartFile 文件]<br>
    * <b>@return：</b>cjava.lang.String[]<br>
    * <b>修改履历：</b>
    *
    * @author 2019/5/9   zhangzhonghao
    */public static String[] upload(String url, MultipartFile[] multipartFile)throws IOException {
        String[] urlArr = new String[multipartFile.length];
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        for (int i = 0; i <multipartFile.length ; i++) {
            String name=multipartFile[i].getOriginalFilename();
            name=name.substring(name.indexOf("."));
            name=name.toLowerCase();
            String uuid = UUID.randomUUID().toString();
            PutObjectResult headerResponse = obsClient.putObject("obs-huifan", uuid+name, multipartFile[i].getInputStream());
            urlArr[i]=url+"/"+headerResponse.getObjectKey();
        }
          // 关闭obsClient
        try {
            obsClient.close();
        } catch (IOException e) {
        }
        return urlArr;
    }
    /**
    * <b>方法名：</b>文件刪除<br>
    * <b>说明：</b> <br>
    * <b>@param </b>[key]<br>
    * <b>@return：</b>cvoid<br>
    * <b>修改履历：</b>
    *
    * @author 2019/5/9   zhangzhonghao
    */
    public static void  deleteOBS(String key){
        key=key.substring(key.lastIndexOf("/")+1);
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        obsClient.deleteObject("obs-huifan", key);
    }
}
