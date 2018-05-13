package com.kele.copy;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.FileAlreadyExistsException;

public class FileCopier implements Copy{

    public FileCopier(){}



    @Override
    public synchronized void copyDir(String dirFromAbsolutePath, String toDir)
            throws FileNotFoundException, FileAlreadyExistsException, IOException{
        File from = new File(dirFromAbsolutePath);
        File to = new File(toDir);
        if(!from.exists()) throw new FileNotFoundException("原文件夹不存在");
        if(!to.exists()) throw new FileNotFoundException("目标文件夹不存在");
        if(from.isFile()) throw new IOException("原文件不是文件夹类型");

        copyAllFileFromDir(from, toDir);

    }

    @Override
    public synchronized void copyFile(String fileFromAbsolutePath, String toDir) throws FileNotFoundException, FileAlreadyExistsException, IOException{
        // from/to:Absolute path
        File from = new File(fileFromAbsolutePath);
        File to = new File(toDir);
        if(!from.exists()) throw new FileNotFoundException("原文件不存在");
        if(!to.exists()) throw new FileNotFoundException("目标文件夹不存在");
        if(from.isDirectory()) throw new IOException("原文件是文件夹类型");
        String newName = from.getName();
        System.out.println("原文件名:" + newName);
        String newFilePath = toDir + "\\" + newName;
        File newFile = new File(newFilePath);
        if(newFile.exists()) throw new FileAlreadyExistsException(newFilePath + "已经存在");
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(fileFromAbsolutePath).getChannel();
            outputChannel = new FileOutputStream(newFilePath).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }catch (IOException e){
            throw e;
        }
        finally {
            if(inputChannel != null) inputChannel.close();
            if(outputChannel != null) inputChannel.close();
        }
    }

    private void copyAllFileFromDir(File source, String toDir){
        /*
        *  调用者保证source和toDir都存在
        * */
        if(source.isDirectory()){
            // 复制文件夹
            String dirName = source.getName();
            String dirPath = toDir + "\\" + dirName;
            File newDir = new File(dirPath);
            System.out.println("新文件夹绝对路径：" + dirPath);
            try{
                if(newDir.mkdir()){
                    File[] files = source.listFiles();
                    for(File child : files){
                        if(child.isDirectory())
                            copyAllFileFromDir(child, dirPath);
                        else {
                            copyFile(child.getAbsolutePath(), dirPath);
                        }
                    }
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            // 复制文件
            String filePath = toDir + "\\" + source.getName();
            File newFile = new File(filePath);
            System.out.println("新文件绝对路径：" + filePath);
            try{
                copyFile(source.getAbsolutePath(), filePath);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
