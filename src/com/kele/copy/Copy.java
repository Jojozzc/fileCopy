package com.kele.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public interface Copy {

    // 把原文件拷贝到toDir目录
    public void copyFile(String fileFromAbsolutePath, String toDir)
            throws FileNotFoundException, FileAlreadyExistsException, IOException;

    // 把原目录下的所有文件拷贝到toDir目录
    public void copyDir(String dirFromAbsolutePath, String toDir)
            throws FileNotFoundException, FileAlreadyExistsException, IOException;
}
