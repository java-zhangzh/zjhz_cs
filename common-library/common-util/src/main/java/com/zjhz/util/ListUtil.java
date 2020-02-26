package com.zjhz.util;

import java.io.*;
import java.util.List;

/**
 * <b>功能名：</b>ListUtil<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 zjhz  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-06-21 Cheng
 */
public class ListUtil {


    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }
}
