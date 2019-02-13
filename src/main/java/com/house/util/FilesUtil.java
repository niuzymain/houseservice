package com.house.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
文件存储工具类
 */
public class FilesUtil {
    private static final SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String saveHeadimg(InputStream inputStream,Long headimgid,String filename) throws Exception {
        String realname = "headimg"+headimgid+"_"+sformat.format(new Date());   //文件名
        String extensionname = getExtensionname(filename);  //扩展名
        String savename = realname+extensionname;
        String savedir = PathUtil.rootPath()+PathUtil.headimgPath(); //存储目录
        Mkdir(savedir);
        String savepath = savedir+savename; //绝对路径
        File file = new File(savepath);
        SaveFile(inputStream,file); //存储文件
        return PathUtil.headimgPath()+savename;  //返回相对路径
    }

    /*
    删除文件
     */
    public static void deleteFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }
    /*
    保存文件
     */
    private static void SaveFile(InputStream inputStream, File file) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int byteread = 0;
        byte[] buffer = new byte[8192];
        while ((byteread = inputStream.read(buffer, 0, 8192)) != -1) {
            fileOutputStream.write(buffer, 0, byteread);
        }
        fileOutputStream.close();
        inputStream.close();
    }
    /*
    创建目录
     */
    private static void Mkdir(String savedir) {
        File dir = new File(savedir);
        if(!dir.exists()){
            dir.mkdirs();
        }
    }
    /*
    获取扩展名
     */
    private static String getExtensionname(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    public static void main(String[] args){
        try {
//            System.out.println(saveHeadimg(new FileInputStream("g:\\ultimate.jpg"),"ultimate.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
