package com.zjhz.util;

import com.zjhz.base.annotaion.Permission;
import com.zjhz.base.constants.Constant;
import org.springframework.util.StringUtils;

/**
 * Created by 12947 on 2019/5/25.
 */
public class HasPermissionUtil {


    /**
     * 判断是否有权限
     * @param code	权限代码
     * @return
     */
    public static boolean isContainPermission(Permission classPermission,Permission monethPermssion, String tag, String code, String [] permissions){
        //判断是否是前端小程序api
        if(!StringUtils.isEmpty(tag)){
            if(tag.trim().equals(Constant.CLIENT_APP)){
                return  true;
            }
        }
        StringBuffer sb=new StringBuffer();
        sb.delete(0, sb.length());
        String[] arr = code.split (",");
        for (int i = 0; i < permissions.length; i++) {
            if(permissions[i]!=null&&!permissions[i].equals("")){
                sb.append(permissions[i].trim());
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(sb.indexOf(arr[i])==-1){
                return false;
            }
        }
        System.out.println(sb.toString());
        return true;
    }


    public static  boolean hasPermission(Permission classPermission,Permission methodPermission,String tag, String [] permissions){
        Boolean flag=true;
        if(classPermission!=null){
            String classCode = classPermission.value();
            flag = isContainPermission(classPermission,methodPermission,Constant.CLIENT_APP,classCode,permissions) ;
        }

        if(flag&&methodPermission!=null){
            String methodcode = methodPermission.value();
            flag = isContainPermission(classPermission,methodPermission,Constant.CLIENT_APP,methodcode,permissions) ;        }
        return flag;

    }


}
