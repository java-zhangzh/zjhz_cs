package com.zjhz.util;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;

public class FileUtil {
	
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine())!= null){
			sb.append(s);
		}
		in.close();
		return sb.toString();
	}
	public static void copyfile(String inputname,String outputname) throws IOException{
		InputStream in = new FileInputStream(inputname);
		OutputStream out = new FileOutputStream(outputname);
		byte[] buffer = new byte[1024];
		int read = 0;
		while((read = in.read(buffer))!= -1){
			out.write(buffer,0,read);
			System.out.print(read);
			System.out.print(buffer);
			System.out.print("/n");
		}
		in.close();
		out.close();
	}
	public static void copyDir(String inputname,String outputname) throws IOException{
		(new File(outputname)).mkdirs();
		File[] file=(new File(inputname)).listFiles();
		if(file==null){
			return;
		}
		for(int i=0;i<file.length;i++){
			if(file[i].isFile()){
				file[i].toString();
				FileInputStream input=new FileInputStream(file[i]);
				//mkdir if destination does not exist
				File outtest = new File(outputname);
				if (!outtest.exists()){
					outtest.mkdir();
				}
				FileOutputStream output=new FileOutputStream(outputname+"/"+(file[i].getName()).toString());
				byte[] b=new byte[1024*5];
				int len;
				while((len=input.read(b))!=-1){
					output.write(b,0,len);
				}
				output.flush();
				output.close();
				input.close();
			}else if (file[i].isDirectory()){
			
				copyDir(file[i].toString(),outputname+ "//" + file[i].getName());
			}
		}
	}
	public static String getSuffixName(String fileName){
		int index = fileName.lastIndexOf(".");
		if(index==-1){
			return "";
		}
		return fileName.substring(index);
	}
	
	
	/**
     */
    public static void doDeleteEmptyDir(String dir) {
        boolean success = (new File(dir)).delete();
    }

    /**
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
    
    public static void mkdir(String path){
    	File file = new File(path);
    	if(!file.exists()){
    		int index = path.lastIndexOf("/");
    		if(index==-1){
    			index = path.lastIndexOf("\\");
    		}
    		file = new File(path.substring(0,index));
    	}
    	if(!file.exists()){
    		file.mkdirs();
    	}
    	
    }


	public static MultipartFile base64ToMultipart(String base64) {
		try {
			String[] baseStrs = base64.split(",");

			BASE64Decoder decoder = new BASE64Decoder();
			byte[] b = new byte[0];
			b = decoder.decodeBuffer(baseStrs[1]);

			for(int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}

			return new BASE64DecodedMultipartFile(b, baseStrs[0]);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}