package com.cui.cn.java8;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 86183 - cuizhihao
 * @create 2024-06-05-23:38
 */
public class FileMain {

    public static void main(String[] args) {

        FileMain fileMain = new FileMain();
        fileMain.method02();

    }

    public void method02(){

        String [] str = {"1","ef","dfa","321","2"};
        List<String> strings = Arrays.asList(str);
        System.out.println(strings); // [1, ef, dfa, 321, 2]
        //strings.set(2,"22");
        strings.add(1,"12");
        System.out.println(strings);

    }

    public void method01(){

        File file = new File("D:\\日常工具文件夹\\微信公众号文章下载神器\\下载\\猫哥的视界");
        if(file.exists() || file.isDirectory()){
            File[] files = file.listFiles();
            List<File> files1 = Arrays.asList(files);
            List<File> list = new ArrayList(files1);
            Iterator<File> iterator = list.iterator();
            while (iterator.hasNext()){
                File next = iterator.next();
                if(next.isFile() && !next.getName().endsWith(".docx")){
                    System.out.println(next.delete());
//                    iterator.remove();
                }
            }

        }

    }

}
