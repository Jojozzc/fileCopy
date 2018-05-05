package com.kele.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileCopier {
    public FileCopier(){}

    private void copyFile(File from, File to) throws Exception{
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(from).getChannel();
            outputChannel = new FileOutputStream(to).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }finally {
            if(inputChannel != null) inputChannel.close();
            if(outputChannel != null) inputChannel.close();
        }
    }


    public void copyFile(String from, String to) throws Exception{
        // from/to:Absolute path
        File fileFrom = new File(from);
        File fileTo = new File(to);
        copyFile(fileFrom, fileTo);
    }
}
