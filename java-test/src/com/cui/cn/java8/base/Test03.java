package com.cui.cn.java8.base;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test03 {

    public static void main(String[] args) throws InterruptedException, ParseException, IOException, ClassNotFoundException, ExceptionIsMy {

        Test03 t3 = new Test03();
        /*double result = T3.calc(2,3);
        System.out.println(result);*/
        t3.method55();
    }

    public void method55(){

        throw new ExceptionIsMy01();

    }

    public void method54() throws ExceptionIsMy {
        throw new ExceptionIsMy("yichag",new NullPointerException("空值"));
    }

    public void method53(){

        try{

            String str = null;
            //String[] split = str.split("\\s"); // 空指针异常

            String [] arrStr = new String[2];
            // String s = arrStr[2]; // 数组下标越界

            //int a = 10/0; // 计算异常

            Map<String,Integer> map = new HashMap<>();
            Integer integer = map.get("1");
            System.out.println(integer);

        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

    }

    public void method52(){

        try{
            throw new IOException("1122");
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(123);

    }

    public void method51() throws IOException{

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        Reader reader = new FileReader(f1);
        BufferedReader br = new BufferedReader(reader);
        List<StudentOrder> list = new ArrayList<>();
        String line = null;
        while((line = br.readLine()) != null && !line.isEmpty()){
            String[] split = line.split("\\s{1,}");
            if(split.length>0){
                StudentOrder so = new StudentOrder();
                so.setName(split[0].trim());
                so.setNumber(Integer.parseInt(split[1].trim()));
                list.add(so);
            }
        }
        list.sort(Comparator.comparing(StudentOrder::getNumber));
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "studentOrder.txt");
        Writer writer = new FileWriter(f2);
        BufferedWriter bw = new BufferedWriter(writer);
        for (StudentOrder so : list) {
            bw.write(so.getName()+" "+so.getNumber());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void method50() throws IOException {

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "studentOrder2.txt");
        Reader reader = new FileReader(f1);
        BufferedReader br = new BufferedReader(reader);
        List<StudentOrder> list = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            StudentOrder so = new StudentOrder();
            String[] split = line.split("\\s{1,}");
            so.setName(split[0]);
            so.setNumber(Integer.parseInt(split[1].trim()));
            list.add(so);
        }
        list.sort(Comparator.comparing(StudentOrder::getNumber).reversed());
        Writer writer = new FileWriter(f2);
        BufferedWriter bw = new BufferedWriter(writer);
        for (StudentOrder so : list) {
            bw.write(so.getName() + " " + so.getNumber());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public void method49() throws IOException {

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "studentOrder.txt");
        Reader reader = new FileReader(f1);
        BufferedReader br = new BufferedReader(reader);
        List<StudentOrder> list = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            StudentOrder so = new StudentOrder();
            String[] split = line.split("\\s{1,}");
            so.setName(split[0]);
            so.setNumber(Integer.parseInt(split[1].trim()));
            list.add(so);
        }
        Collections.sort(list);
        Writer writer = new FileWriter(f2);
        PrintWriter pw = new PrintWriter(writer);
        for (StudentOrder so : list) {
            pw.println(so.getName() + " " + so.getNumber());
        }
        pw.flush();
        pw.close();
        br.close();

    }

    public void method48() throws IOException {

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "student.txt");
        Reader reader = new FileReader(f1);
        BufferedReader br = new BufferedReader(reader);
        Writer writer = new FileWriter(f2);
        PrintWriter pw = new PrintWriter(writer);
        String line = null;
        while ((line = br.readLine()) != null) {
            pw.println(line);
        }
        /*BufferedWriter bw = new BufferedWriter(writer);
        char [] ch = new char[1024];
        int len = -1;
        while((len = br.read(ch)) != -1){
            bw.write(ch,0,len);
        }*/
        /*String line = null;
        while((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }*/
        pw.flush();
        pw.close();
        br.close();
    }

    public void method47() throws IOException {

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "1.txt");
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "2.txt");
        InputStream is = new FileInputStream(f1);
        Reader reader = new InputStreamReader(is);
        OutputStream os = new FileOutputStream(f2);
        Writer writer = new OutputStreamWriter(os);
        char[] ch = new char[1024];
        int len = -1;
        while ((len = reader.read(ch)) != -1) {
            writer.write(ch, 0, len);
        }
        writer.close();
        reader.close();
    }

    public void method46() throws IOException {

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "1.txt");
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "2.txt");
        Reader reader = new FileReader(f1);
        Writer writer = new FileWriter(f2);
        char[] ch = new char[1024];
        int data = -1;
        while ((data = reader.read(ch)) != -1) {
            writer.write(ch, 0, data);
        }
        writer.close();
        reader.close();
    }

    public void method45() throws IOException {

        File f1 = new File("D:" + File.separator + "fileTest" + File.separator + "1.txt");
        File f2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "1.txt");
        Reader reader = new FileReader(f1);
        Writer writer = new FileWriter(f2);
        int data = -1;
        while ((data = reader.read()) != -1) {
            writer.write(data);
        }
        writer.close();
        reader.close();
    }

    public void method44() throws IOException {
        File file = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        Reader reader = new FileReader(file);
        int read = reader.read();
        System.out.println((char) read);

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "1.txt");
        Writer writer = new FileWriter(file1);
        writer.write("97");
        //writer.flush();
        writer.close();
        reader.close();

    }

    public void method43() throws IOException, ClassNotFoundException {
        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "SortedObject.txt");
        InputStream is = new FileInputStream(file1);
        ObjectInputStream ois = new ObjectInputStream(is);
        SortedObject o = (SortedObject) ois.readObject();
        System.out.println(o);
    }

    public void method42() throws IOException {
        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "SortedObject.txt");
        OutputStream os = new FileOutputStream(file1);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        SortedObject so = new SortedObject("张三", 10, 19, new BigDecimal("18962543"));
        oos.writeObject(so);
        oos.flush();
        oos.close();
    }

    public void method41() throws IOException {

        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "pg" + File.separator + "2.jpeg");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy", "2.jpeg");
        InputStream is = new FileInputStream(file1);
        BufferedInputStream bis = new BufferedInputStream(is);
        OutputStream os = new FileOutputStream(file2);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        byte[] by = new byte[1024];
        int ch = -1;
        while ((ch = bis.read(by)) != -1) {
            bos.write(by, 0, ch);
        }
        bos.flush();
        bos.close();
        bis.close();

    }

    public void method40() throws IOException {

        // 定义复制的file对象 和 被复制的File对象
        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "pg" + File.separator + "1.jpeg");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy", "1.jpeg");
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        byte[] by = new byte[1024];
        int ch = -1;
        while ((ch = is.read(by)) != -1) {
            os.write(by, 0, ch);
        }
        os.close();
        is.close();

    }

    public void method39() throws IOException {

        // 定义复制的file对象 和 被复制的File对象
        File file1 = new File("D:" + File.separator + "fileTest" + File.separator + "student.txt");
        File file2 = new File("D:" + File.separator + "fileTest" + File.separator + "copy" + File.separator + "student.txt");
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);
        int flag = -1;
        while ((flag = is.read()) != -1) {
            os.write(flag);
        }
        is.close();
        os.close();
    }

    public void method38() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "1.txt");
        InputStream is = new FileInputStream(file);
        /*int read = is.read();
        System.out.println((char)read);*/
        byte[] by = new byte[1024];
        int read = is.read(by, 0, 36);
        System.out.println(Arrays.toString(by));
        System.out.println(new String(by, 0, read));

    }

    public void method37() throws IOException {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "1.txt");
        OutputStream os = new FileOutputStream(file, true);
//        os.write(97);
        os.write("hello,你好".getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    // 文件过滤器的使用
    public void method36() {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "pg");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File f = new File(dir, name);
                return f.isFile() && f.getName().endsWith(".jpeg");
            }
        });
        System.out.println(Arrays.toString(list));
        /*File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println(pathname);
                return pathname.isFile() && pathname.getName().endsWith(".jpeg");
            }
        });
        System.out.println(Arrays.toString(files));*/

        /*File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //System.out.println(dir);
                //System.out.println(name);
                File f = new File(dir, name);
                return f.isFile() && f.getName().endsWith(".jpeg");
            }
        });
        System.out.println(Arrays.toString(files));
        for (File file1 : files) {
            System.out.println(file1);
        }*/

    }

    // 获取指定文件夹下的所有图片
    public void method35() {

        File file = new File("D:" + File.separator + "fileTest" + File.separator + "pg");
        // 判断指定文件夹是否存在
        if (file.exists()) {
            // 获取指定问文件夹下所有的文件
            File[] files = file.listFiles();
            // 判断文件是
            for (File fi : files) {
                if (fi.isFile() && fi.getName().endsWith(".jpeg")) {
                    System.out.println(fi);
                }
            }
        }
    }

    // io file
    public void method34() throws IOException {

        /*File file = new File("D:"+File.separator+"fileTest"+File.separator+"1.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);*/
        File file = new File("D:" + File.separator + "fileTest");
        File file1 = new File(file, "ac");
        File file2 = new File(file, "a2.txt");
        //boolean b = file1.renameTo(file2);
        //System.out.println(b);
        boolean file3 = file2.canWrite();
        System.out.println(file3);
        /*if(file.exists()){
            String name = file.getName();
            boolean newFile = file1.createNewFile();
            System.out.println(newFile);
        }
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());*/

    }

    public void method33() {

        Map<String, Integer> map = new TreeMap<>();
        map.put("123", 123);
        map.put("567", 567);
        map.put("345", 345);
        map.put("456", 456);
        System.out.println(map);

        /*Map<String,Integer> map = new  ConcurrentHashMap();
        map.put("123",123);
        System.out.println(map);*/

        /*Map<String,Integer> map = new HashMap<>();
        Map<String, Integer> stringIntegerMap = Collections.synchronizedMap(map);
        stringIntegerMap.put("123",123);
        System.out.println(stringIntegerMap);*/
    }

    public void method32() {

        Set<String> set = new TreeSet<>();
        set.add("123");
        set.add("123");
        set.add("321");
        System.out.println(set);
    }

    public void method31() {

        Map<String, Double> map = new HashMap<>();
        map.put("s", 88.9);
        map.put("d", 85.9);
        map.put("w", 68.9);
        map.put("c", 98.9);
        Collection<Double> values = map.values();
        Iterator<Double> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /*Set<Map.Entry<String, Double>> entries = map.entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }*/

        /*Set<String> keys = map.keySet();
        System.out.println(keys);
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + " = " + map.get(key));
        }*/

    }

    public void method30() {

        Map<String, Integer> map = new HashMap<>();
        Integer put = map.put("1", 1);
        Integer put1 = map.put("2", 2);
        map.put("3", 3);
        Integer put2 = map.put("3", 33);
        System.out.println(put);
        System.out.println(put1);
        System.out.println(put2);
        Integer integer = map.get("1");
        System.out.println(integer);
        boolean b = map.containsKey("00");
        System.out.println(b);

    }

    public void method29() {

        Deque<Integer> deque = new LinkedList<>();
        deque.push(12);
        deque.push(21);
        deque.push(23);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
    }

    public void method28() {

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        System.out.println(deque);
        System.out.println(deque.pollLast());

    }

    public void method27() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(6);
        queue.offer(3);
        queue.offer(2);
        queue.offer(9);
        System.out.println(queue);
        while (queue.size() != 0) {
            System.out.println(queue.poll());
        }
        System.out.println("数据中的数据还有吗：" + queue);
    }

    public void method26() {

        List<SortedObject> list = new ArrayList<>();
        list.add(new SortedObject("张三", 10, 19, new BigDecimal("18962543")));
        list.add(new SortedObject("lisi", 25, 1192, new BigDecimal("5678189")));
        list.add(new SortedObject("wangwu", 25, 1299, new BigDecimal("183459")));
        list.add(new SortedObject("zhaoliu", 25, 1192, new BigDecimal("12389")));
        list.add(new SortedObject("quba", 25, 1192, new BigDecimal("1852439")));
        list.add(new SortedObject("quba", 27, 111, null));
        list.add(new SortedObject("quba", null, 111, null));
        //list.sort(Comparator.comparing(SortedObject::getNumber));
//        list.sort(Comparator.comparing(SortedObject::getAge).reversed());
        //list.sort(Comparator.comparing(SortedObject::getAge).thenComparing(SortedObject::getNumber).reversed().thenComparing(SortedObject::getMoney));
        //list.sort(Comparator.comparing(SortedObject::getAge).thenComparing(Comparator.comparing(SortedObject::getNumber).reversed()));
        list.sort(Comparator.comparing(SortedObject::getAge, Comparator.nullsFirst(Integer::compareTo)).thenComparing(SortedObject::getMoney, Comparator.nullsLast(BigDecimal::compareTo)));
        for (SortedObject sortedObject : list) {
            System.out.println(sortedObject);
        }
    }

    public void method25() {

        List<Student> list = new ArrayList<>();
        list.add(new Student("积极", 123, 1231));
        list.add(new Student("liji", 13, 2121));
        list.add(new Student("积极g", 3, 271));
        list.add(new Student("积极a", 23, 1));
        list.add(new Student("积极3", 543, 1234231));
        list.add(new Student("积极2", 876, 11));
        list.add(new Student("积极1", 7345, 119));
        Collections.sort(list, new Student());
        /*Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getNumber()-o2.getNumber();
            }
        });*/
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void method24() {

        List<Integer> list = new ArrayList<>();
        list.add(7456);
        list.add(74);
        list.add(56);
        list.add(6);
        list.add(456);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

    }

    public void method23() {

        String[] str = {"1", "w", "c", "d"};
        List<String> list = Arrays.asList(str);
        String set = list.set(1, "222");
        System.out.println(set);

        System.out.println(list);

    }

    public void method22() {

        int[] in = {};
        int[] in1 = new int[1];
        int[] in2 = new int[]{};

        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        String[] s = new String[]{};
        String[] ts = list.toArray(s);
        System.out.println(Arrays.toString(ts));

    }

    public void method21() {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(1, 66);
        Integer set = list.set(1, 88);
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            System.out.println(integer);
        }

    }

    public void method20() {

        Collection<Integer> c = new ArrayList();
        c.add(10);
        c.add(11);
        c.add(12);
        c.add(13);


        //Iterator<Integer> iterator = c.iterator();
        /*while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next.equals(12)){
                iterator.remove();
            }
        }
        System.out.println(c);*/

        /*for (Integer data : c) {
            System.out.println(data);
        }*/

    }

    public void method19() {

        Collection<Integer> c = new ArrayList();
        c.add(10);
        c.add(11);
        c.add(12);
        c.add(13);
        Collection<String> cs = new ArrayList<>();
        cs.add("12");
        cs.add("11");
        cs.add("10");
        boolean b = c.containsAll(cs);
        System.out.println(b);
        System.out.println(c);
        boolean contains = c.contains(121);
        System.out.println(contains);
        int size = c.size();
        System.out.println(size);
    }

    public void method18() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime1 = LocalDateTime.of(2024, 7, 25, 16, 30, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 8, 31, 16, 30, 56);
        // String format = dtf.format(localDateTime2);
        // System.out.println(format);
        boolean after = localDateTime1.isAfter(localDateTime2);
        System.out.println(after);
        int i = localDateTime1.compareTo(localDateTime2);
        System.out.println(i);
        int i1 = localDateTime2.compareTo(localDateTime1);
        System.out.println(i1);

    }

    public void method17() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr1 = "2024-07-25";
        String dateStr2 = "2024-08-31";
        Date parse = sdf.parse(dateStr1);
        Date parse1 = sdf.parse(dateStr2);
        int i = parse.compareTo(parse1);
        System.out.println(i);
        boolean before = parse.before(parse1);
        System.out.println(before);

    }

    public void method16() {

        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.ofHours(8));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(localDateTime);
        System.out.println(format);


        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.withDayOfYear(90);
        System.out.println(localDate1);

    }

    public void method15() throws InterruptedException {

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusMonths(1).plusDays(20);
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.now();
        System.out.println(localDate2.getDayOfWeek());
        System.out.println(localDate2.getDayOfMonth());
        System.out.println(localDate2.getDayOfYear());

        LocalDate localDate3 = localDate2.minusDays(31);
        System.out.println(localDate3);


        /*Instant now = Instant.now();
        Thread.sleep(1000);
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());*/

        /*LocalDate localDate = LocalDate.now();
        //Thread.sleep(1000);
        LocalDate localDate1 = LocalDate.of(2022,9,30);
        Period between1 = Period.between(localDate1,localDate);
        System.out.println(between1.getDays());
        System.out.println(between1.getMonths());
        System.out.println(between1.getYears());*/

    }

    public static final int A = 999_999;

    public void method14() {

        Instant instant = Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

    }

    public void method13() {

        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);

    }

    public void method12() {

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(today);
        System.out.println(format);

    }

    public void method11() {

        Boolean aBoolean = RegexDateUtil.regexAll("2021-02-29");
        System.out.println(aBoolean);

    }

    public void method10() {

        String str1 = "2022-01-01";
        int i = str1.indexOf("-");
        System.out.println(i);
        String substring = str1.substring(0, i);
        System.out.println(substring);

        String regex = "([0-9]*)([a-z]{0,})([A-Z]{1})";
        String str = "123adaswww111ssAAAABBB2457qSFDG000Asdf";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.find();
        String group = matcher.group(0);
        System.out.println(group);
        System.out.println(b);

    }

    public void method09() {

        String str = "start ab start cd ef start gg";
        String re = "start";
        Matcher m = Pattern.compile(re).matcher(str);
        System.out.println(m.find()); // true
        System.out.println(m.group()); // start；配合find的结果使用，不然会报错
        System.out.println(m.start());
        System.out.println(m.end());

    }

    public void method08() {

        String regex = "[0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("99");
        String s = matcher.replaceAll("w");
        System.out.println(s);
        boolean matches = matcher.matches();
        System.out.println(matches);

    }

    public void method07() {

        String flag = null;
        String regex = "[0-9]{1,4}";
        boolean matches = flag.matches(regex);
        System.out.println(matches);


    }

    public void method06() {

        Student student = null;
//        String s = student.toString();
        String value = String.valueOf(student);
//        System.out.println(s);
        System.out.println(value);
    }

    public void method05() {

        String str = null;
        String value = String.valueOf(str);
        Integer i = null;
        String s = i.toString();
        System.out.println(s);

    }

    public void method04() {

        String s1 = null;
        if (s1 != null && s1.isEmpty()) {
            System.out.println(111);
        }
        String str = "h1e3l4oo0o00AasaDE0";
        String s = str.replaceAll("[a-zA-Z]", "");
        System.out.println(s);
        /*char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));*/
    }

    public void method03() {

        String str = " he llo ";
        String substring = str.substring(3, 4);
        System.out.println(str);
        String trim = str.trim();
        System.out.println(trim);
        System.out.println(substring);

    }

    // 求一个字符串中子串出现的次数
    public void method02() {

        String str = "cbcbcbcbcbcbcbc";
        String strSon = "cbc";
        int length = strSon.length();
        int flag = 0;  // 初始化字串开始搜索的位置
        int number = 0; // 统计字串出现的次数
        while (true) {
            int i = str.indexOf(strSon, flag);
            if (i == -1) {
                break;
            } else {
                flag = 1 + i;
                number += 1;
            }
        }
        System.out.println(number);
    }

    public void method01() {

        String str = "qwertyuiop";
        System.out.println(str.length());
        int y = str.indexOf("p", 6);
        System.out.println(y);

    }

    public double calc(int a, int b) {
        double c = 9.0;
        double d = 100.0;
        c++;
        int w = 1;
        w++;
        return c;

       /* int c = 100;
        c = a + b;
        return c;*/
    }
}