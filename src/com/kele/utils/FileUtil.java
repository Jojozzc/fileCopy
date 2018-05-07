package com.kele.utils;

import java.io.File;

public class FileUtil {
    private static FileUtil instance = new FileUtil();
    private FileUtil(){};

    public static FileUtil getInstance() {
        return instance;
    }

    public void mkdir(String absoluteRootPath, String dirName){
        File file = new File(absoluteRootPath + dirName);
        file.mkdir();
    }
}
