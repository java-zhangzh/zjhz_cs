package com.zjhz.gismap.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BASE64DecodedMultipartFile implements MultipartFile {

    private final byte[] imgContent;
    private final String header;

    public BASE64DecodedMultipartFile(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
    }

    @Override
    public String getName() {
        // TODO - implementation depends on your requirements
        String suff=header.split(",")[0].split("\\.")[1];
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return  sdf.format(new Date())+ Math.random() + "." +suff ;
    }

    @Override
    public String getOriginalFilename() {
        // TODO - implementation depends on your requirements
        String suff=header.split(",")[0].split("\\.")[1];
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return  sdf.format(new Date())+ Math.random() + "." +suff ;
    }

    @Override
    public String getContentType() {
        // TODO - implementation depends on your requirements
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }
}
