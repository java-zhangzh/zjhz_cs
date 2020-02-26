package com.zjhz.util;

import java.util.ArrayList;

/**
 *  zhangzhonghao 2019/5/30.
 */
public   class  TicketEnumUtil {
    /**
    * <b>方法名：</b>生成一个字符存进数据库<br>
    * <b>说明：</b> <br>
    * @param code
    * @return int
    * <b>修改履历：</b>
    *
    * @author 2019/5/30   zhangzhonghao
    */
    public static int  getTicketType(Integer[] code){
        ArrayList<Integer> list = new ArrayList<>();
        TicketEnum[] values = TicketEnum.values();
        for (int i =0; i < code.length;i++){
            for (int j = 0; j < values.length;j++){
                boolean b = (code[i] & values[j].getCode()) ==values[j].getCode();
                if (b == true){
                    list.add(values[j].getCode());
                }
            }
        }
        if (list.size()> 1){
            Integer value  = 0;
             for (int y = 0; y <list.size();y++ ) {
                 value  = list.get(y) | value;
             }
            return value;
        }else {
         return list.get(0);
        }
    }
    /**
    * <b>方法名：</b>数据库里存的字符那几个组成<br>
    * <b>说明：</b> <br>
    * @param code
    * @return java.util.ArrayList<java.lang.Integer>
    * <b>修改履历：</b>
    *
    * @author 2019/5/30   zhangzhonghao
    */public static  ArrayList<Integer>  getTicket(Integer code){
        ArrayList<Integer> list = new ArrayList<>();
        TicketEnum[] values = TicketEnum.values();
        for (TicketEnum value : values) {
            boolean b = (code & value.getCode()) == value.getCode();
            if (b) {
                list.add(value.getCode());
            }
        }
        return list;
    }

}
