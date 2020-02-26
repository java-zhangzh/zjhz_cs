package com.zjhz.gismap.config;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author weike,
 * @date 2019/7/12
 * @time 11:32
 */
public class MyBeanSerializerModifier extends BeanSerializerModifier {



    //  数组类型
    private JsonSerializer _nullArrayJsonSerializer = new MyNullArrayJsonSerializer();
    // 字符串等类型
    private JsonSerializer _nullJsonSerializer = new MyNullJsonSerializer();

    private JsonSerializer _nullIntegrSerializer=new MyIntegrSerializer();

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                     List beanProperties) {
        //循环所有的beanPropertyWriter
        for (int i = 0; i < beanProperties.size(); i++) {
            BeanPropertyWriter writer = (BeanPropertyWriter) beanProperties.get(i);
            //判断字段的类型，如果是array，list，set则注册nullSerializer
            switch (isArrayType(writer))
            {
                //list  set array
                case "List": {
                    writer.assignNullSerializer(this._nullArrayJsonSerializer);
                    break;
                }
                case "String":{
                    writer.assignNullSerializer(this._nullJsonSerializer);
                    break;
                }
                case "Integr":{
                    writer.assignNullSerializer(this._nullIntegrSerializer);
                    break;
                }
                case "Date":{
                    writer.assignNullSerializer(this._nullJsonSerializer);
                    break;
                }

            }
                //给writer注册一个自己的nullSerializer
        }
        return beanProperties;
    }

    //判断是什么类型
    protected String isArrayType(BeanPropertyWriter writer) {
        Class clazz = writer.getPropertyType();
        if(clazz.isArray() || clazz.equals(List.class) || clazz.equals(Set.class))
        {
            return "List";
        } else  if(clazz.equals(Integer.class)||clazz.equals(int.class))
        {
            return "Integr";
        }
        else  if(clazz.equals(Date.class))
        {
            return "Date";
        }
        else{

            return  "String";
        }
    }

}
