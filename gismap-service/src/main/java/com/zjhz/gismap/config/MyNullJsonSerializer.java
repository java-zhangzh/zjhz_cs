package com.zjhz.gismap.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author weike,
 * @date 2019/7/12
 * @time 11:31
 */
public class MyNullJsonSerializer extends JsonSerializer {


    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(value==null) {
            gen.writeString("");
        }
    }
}
