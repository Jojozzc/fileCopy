package com.kele.test;

import com.kele.copy.FileCopier;

public class Main {
    public static void main(String[] args){
        FileCopier copier = new FileCopier();
        String from = "F:\\Code\\t1.txt";
        String to = "F:\\Code\\t2.txt";
        try {
            copier.copyFile(from, to);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
