package com.zjhz.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * Created by 12947 on 2019/5/25.
 */
public class AnalysisRedisPermissionUtil {

    public static String[] getPersissionArray(String redisPermsisionJsonStr){

        String permissions []={};
        JSONObject json= JSONObject.parseObject(redisPermsisionJsonStr);
        JSONArray arrays= json.getJSONArray("permissionList");
        if(arrays!=null&&arrays.size()>0){
            for(int i=1;i<arrays.size();i++){
                if(arrays.get(i)!=null){
                    String codeStr=arrays.get(i).toString().replaceAll("\\[|\\]","");
                    permissions=  Arrays.copyOfRange( codeStr.split(","),0, codeStr.split(",").length);
                    break;
                }

            }
        }
        return permissions;
    }

}
