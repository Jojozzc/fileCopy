package com.kele.test;

import com.kele.copy.FileCopier;

import java.io.File;

public class Main {
    public static void main(String[] args){
//        newFileTest();
        dirCopyTest();
    }



    private static void newFileTest(){
        String fileName = "F:\\Code\\t3.txt";
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private static void copyTest(){
        FileCopier copier = new FileCopier();
        String from = "F:\\Code\\t1.txt";
        String to = "F:\\Code\\t2.txt";
        try {
            copier.copyFile(from, to);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void dirCopyTest(){
        FileCopier copier = new FileCopier();
        String from = "F:\\Code\\test1";
        String to = "F:\\Code\\test2";
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
