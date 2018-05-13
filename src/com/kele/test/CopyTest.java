package com.kele.test;

import com.kele.copy.Copy;
import com.kele.copy.FileCopier;
import org.junit.Test;

import java.util.Scanner;

public class CopyTest {
//    @Test
    public void fileCopyTest(){
        Copy copier = new FileCopier();
        String from = "F:\\Code\\JavaCode\\fileCopy\\testSpace\\from\\haha.txt";
        String to = "F:\\Code\\JavaCode\\fileCopy\\testSpace\\to";

        try{
            copier.copyFile(from, to);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    @Test
    public void dirCopyTest(){
        String from = "F:\\Code\\JavaCode\\fileCopy\\testSpace\\from";
        String to = "F:\\Code\\JavaCode\\fileCopy\\testSpace\\to";
        FileCopier fileCopier = new FileCopier();
        try{
            fileCopier.copyDir(from, to);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
