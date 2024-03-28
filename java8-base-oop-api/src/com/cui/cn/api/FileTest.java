package com.cui.cn.api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-25-12:25
 */
public class FileTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileTest fileTest = new FileTest();
        fileTest.method15();

//        fileTest.method06();
    }

    public void method15() throws IOException {

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "student2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        List<Student> list = new ArrayList<>();
        String line = null;
        while((line = br.readLine()) != null){
            Student student = new Student();
            String[] split = line.split("\\s+");
            student.setName(split[0]);
            student.setNumber(Integer.parseInt(split[1].trim()));
            list.add(student);
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        for (Student student : list) {
            StringBuffer sbu = new StringBuffer();
            sbu.append(student.getName()+" "+student.getNumber());
            bw.write(sbu.toString());
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();

    }

    public void method14() throws IOException {

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "random.txt");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "random5.txt");
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        Reader reader = new InputStreamReader(is);
        Writer writer = new OutputStreamWriter(os);
        char [] ch = new char[1024];
        int len = -1;
        while((len = reader.read(ch)) != -1){
            writer.write(ch,0,len);
            writer.flush();
        }
        reader.close();
        writer.close();

    }

    public void method13() throws IOException {

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "random.txt");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "random4.txt");
        Reader reader = new FileReader(file1);
        Writer writer = new FileWriter(file2);
        char [] ch = new char[1024];
        int len = -1;
        while ((len = reader.read(ch)) != -1){
            System.out.println(Arrays.toString(ch));
            writer.write(ch,0,len);
        }
        writer.close();
        reader.close();
    }

    public void method12() throws IOException, ClassNotFoundException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "Student.txt");

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student o = (Student)ois.readObject();
        System.out.println(o);
        ois.close();

        // 创建对象流 -> 序列化
        /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student student = new Student(UUID.randomUUID().toString(),"张三",23,"这个就很溜");
        oos.writeObject(student);
        oos.flush();
        oos.close();*/



    }

    public void method11() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "random1.txt");
        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "random2.txt");
        //BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
        //RandomAccessFile raf = new RandomAccessFile(file,"rw");
        String str = null;
        while ((str = br.readLine()) != null){
            if(str.contains("hello")){
                String s = str.replaceAll("hello", "hello,tom");
                bw.write(s);
            }else{
                bw.write(str);
            }
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
        /*byte [] by = new byte[3];
        int read1 = raf.read();
        by[0] = (byte)read1;
        int read2 = raf.read();
        by[1] = (byte)read2;
        int read3 = raf.read();
        by[2] = (byte)read3;
        System.out.println(new String(by));*/
        /*long length = file.length();
        raf.seek(length);*/
        // raf.write("-新插入的数据".getBytes(StandardCharsets.UTF_8));
        /*byte [] by = new byte[1024];
        int len = -1;
        while((len = raf.read(by)) != -1){
            System.out.println(Arrays.toString(by));
            System.out.println(new String(by,0,len));
        }*/
        //raf.write("你好,hello,随机访问流".getBytes(StandardCharsets.UTF_8));
        //raf.close();
    }

    public void method10() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "aNEW.txt");
        InputStream is = new FileInputStream(file);

        // 读取指定长度的的字符，并转换成字节数组
        byte [] by = new byte[12];
        int read = is.read(by,2,5);
        // 读取的内容在字节数组中保存
        System.out.println(Arrays.toString(by)); // [104, 101, 108, 108, 111, 44, -28, -67, -96, -27, -91, -67]
        System.out.println(new String(by)); // hello,你好
        // 返回值为有效的字节数组的长度
        System.out.println(read); // 12

        /*OutputStream os = new FileOutputStream(file);
        byte[] bytes = "hello,你好".getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes.length);
        os.write(bytes,0,bytes.length);
        os.close();*/
    }

    public void method09() throws UnsupportedEncodingException {

        /**
         * 编码
         * utf-8：一个汉字三个字节
         */
        String str = "hello,123,你好";
        byte[] b1 = str.getBytes(); // 通过平台默认的编码格式将字符转换成字节
        byte[] b2 = str.getBytes(StandardCharsets.UTF_8); // 使用指定的编码格式将字符转换成字节
        System.out.println(Arrays.toString(b1)); // [104, 101, 108, 108, 111, 44, 49, 50, 51, 44, -28, -67, -96, -27, -91, -67]
        System.out.println(Arrays.toString(b2)); // [104, 101, 108, 108, 111, 44, 49, 50, 51, 44, -28, -67, -96, -27, -91, -67]
        /**
         * 解码
         * utf-8：一个汉字三个字节
         */
        String s = new String(b1);
        System.out.println(s); // hello,123,你好
        String s1 = new String(b2, "utf-8");
        System.out.println(s1); // hello,123,你好
        // 将字节数组b1，从下标0开始，截取13个字节，转换成字符
        String s2 = new String(b1, 0, 13);
        System.out.println(s2); // hello,123,你

        /*for (int i = 0; i<str.length();i++){
            System.out.println(str.charAt(i));
        }*/
        /*char c = str.charAt(1);
        System.out.println(c);*/

    }

    // 随机访问流
    public void method07() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "random1.txt");
        if(!file.exists()){
            file.createNewFile(); // 判断文件是都存在，如果不存在直接删除
        }
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
//        raf.write("hello,随机访问流".getBytes(StandardCharsets.UTF_8));
//        System.out.println(file.length());
        System.out.println(raf.getFilePointer());
        byte [] by = new byte[1024];
        int len = -1;
        while ((len = raf.read(by)) != -1) {
            System.out.println(new String(by,0,len));
        }
        raf.close();
    }

    // 对read 和 write研究
    public void method08() throws IOException {

        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "aNEW.txt");
        InputStream is = new FileInputStream(file2);
        byte [] by = new byte[1024];
        int read = is.read(by);
        String s = new String(by);
        System.out.println(s);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        /*OutputStream os = new FileOutputStream(file2);
        System.out.println((int)'a');
//        os.write(97); // 97 对应的
//        os.write("hello,OutPutStream".getBytes(StandardCharsets.UTF_8),5,5);
        os.write("hello,OutPutStream".getBytes(StandardCharsets.UTF_8)); // 输出 abc
        os.close();*/
    }

    public void method06() throws IOException {

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "pg" + File.separator+"1.jpeg");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "pgw" + File.separator + "copy2.jpeg");
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        byte [] by = new byte[1024];
        int len = -1;
        while((len = bis.read(by)) != -1){
            bos.write(by,0,len);
            bos.flush();
        }
        bis.close();
        bos.close();

        /*byte [] by = new byte[1024];
        int len = -1;
        while ((len = is.read(by)) != -1){
            os.write(by,0,len);
        }
        is.close();
        os.close();*/
    }

    // 复制一个文件
    public void method05() throws IOException {

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "a.txt");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "aNEW.txt");
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        int ch = -1;
        while((ch = is.read()) != -1){
            os.write(ch);
        }
        is.close();
        os.close();

    }

    // IO 流
    public void method03() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "a.txt");
        InputStream is = new FileInputStream(file);
        int read = -1;
        while((read = is.read()) != -1){
            System.out.println((char)read);
        }
    }

    public void method04() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "a.txt");
        OutputStream os = new FileOutputStream(file,false);
        //os.write(123);
        os.write("hello,OutPutStream你好".getBytes(StandardCharsets.UTF_8)/*,0,5*/);
        os.close();

    }

    // 获取目录下指定文件
    public void method02() {

        File f = new File("D:" + File.separator + "fileTest" + File.separator + "pg");

        /*File[] files = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println(pathname);
                return pathname.isFile() && pathname.getName().endsWith(".jpeg");
            }
        });*/
        /*File[] files = f.listFiles(file -> {
            return file.isFile() && file.getName().endsWith(".jpeg");
        });
        System.out.println(Arrays.toString(files));*/

        /*File[] jpegs = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir);
                System.out.println(name);
                File file = new File(dir, name);
                return file.isFile() && name.endsWith(".jpeg");
            }
        });
        System.out.println(Arrays.toString(jpegs));*/

        /*if (f.exists()) {
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".jpeg")) {
                    System.out.println(file.getName());
                }
            }

        }*/

        /*if(f.exists()){
            String[] list = f.list();
            System.out.println(Arrays.toString(list));
            for (String s : list) {
                if(s.endsWith(".jpeg")){
                    System.out.println(s);
                }
            }
        }else{
            System.out.println("指定的路径不存在");
        }*/
    }

    public void method01() throws IOException {

        File f = new File("D:" + File.separator + "fileTest" + File.separator + "a.txt");

        File f2 = new File("D:" + File.separator + "fileTest", "aNEW.txt");
        /*boolean newFile = f.createNewFile();
        System.out.println(newFile);
        String name = f.getName();
        System.out.println(name);
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getPath());
        boolean b = f.renameTo(f2);
        System.out.println(b);*/
        System.out.println(f.isFile());
        System.out.println(f.isAbsolute());


    }

}
