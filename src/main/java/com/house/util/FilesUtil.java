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

    public static String saveServicerImg(InputStream img,Long servicerid,String imgname) throws Exception {
        String imgRealname = "servicerimg"+servicerid+"_"+sformat.format(new Date());   //文件名
        String imgExtensionname = getExtensionname(imgname);  //扩展名
        String imgSavename = imgRealname+imgExtensionname;
        String imgSavedir = PathUtil.rootPath()+PathUtil.servicerimg(); //存储目录
        Mkdir(imgSavedir);
        String imgSavepath = imgSavedir+imgSavename; //绝对路径
        File img1 = new File(imgSavepath);
        SaveFile(img,img1); //存储文件
        return PathUtil.servicerimg()+imgSavename;  //返回相对路径
    }

    public static String saveServicerFiles(InputStream file,Long servicerid,String filename) throws Exception {
        String fileRealname = "servicerfile"+servicerid+"_"+sformat.format(new Date());   //文件名
        String fileExtensionname = getExtensionname(filename);  //扩展名
        String fileSavename = fileRealname+fileExtensionname;
        String fileSavedir = PathUtil.rootPath()+PathUtil.servicerfile(); //存储目录
        Mkdir(fileSavedir);
        String fileSavepath = fileSavedir+fileSavename; //绝对路径
        File file1 = new File(fileSavepath);
        SaveFile(file,file1); //存储文件
        return PathUtil.servicerfile()+fileSavename;  //返回相对路径
    }

    public static String saveServicerConntract(InputStream file,Long servicerid,String filename) throws Exception {
        String ScRealname = "servicercontract"+servicerid+"_"+sformat.format(new Date());   //文件名
        String ScExtensionname = getExtensionname(filename);  //扩展名
        String ScSavename = ScRealname+ScExtensionname;
        String ScSavedir = PathUtil.rootPath()+PathUtil.servicerContract(); //存储目录
        Mkdir(ScSavedir);
        String ScSavepath = ScSavedir+ScSavename; //绝对路径
        File file1 = new File(ScSavepath);
        SaveFile(file,file1); //存储文件
        return PathUtil.servicerContract()+ScSavename;  //返回相对路径
    }

    public static String saveReserveConntract(InputStream file,Long reserveid,String filename) throws Exception {
        String RcRealname = "reservecontract"+reserveid+"_"+sformat.format(new Date());   //文件名
        String RcExtensionname = getExtensionname(filename);  //扩展名
        String RcSavename = RcRealname+RcExtensionname;
        String RcSavedir = PathUtil.rootPath()+PathUtil.reserveContract(); //存储目录
        Mkdir(RcSavedir);
        String RcSavepath = RcSavedir+RcSavename; //绝对路径
        File file1 = new File(RcSavepath);
        SaveFile(file,file1); //存储文件
        return PathUtil.reserveContract()+RcSavename;  //返回相对路径
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
    public static String getExtensionname(String filename) {
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
