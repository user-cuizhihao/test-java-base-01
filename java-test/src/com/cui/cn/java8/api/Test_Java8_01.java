package com.cui.cn.java8.api;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-21:55
 */
public class Test_Java8_01 {

    public List<Emp> getEmp() {
        List<Emp> list = new ArrayList<>();
        list.add(new Emp("叶猴", 39, new BigDecimal(7500)));
        list.add(new Emp("张三", 21, new BigDecimal(3500)));
        list.add(new Emp("王五", 54, new BigDecimal(10000)));
        list.add(new Emp("李四", 18, new BigDecimal(3000)));
        list.add(new Emp("赵六", 35, new BigDecimal(5000)));
        list.add(new Emp("田七", 39, new BigDecimal(7000)));
        list.add(new Emp("押吼", 39, new BigDecimal(6500)));
        list.add(new Emp("甜甜", 44, new BigDecimal(7000)));
        list.add(new Emp("王八", 24, new BigDecimal(7000)));
        return list;
    }

    private List<SortedObject> getSortedObject() {
        List<SortedObject> list = new ArrayList<>();
        list.add(new SortedObject("张三", 10, 19, new BigDecimal("987")));
        list.add(new SortedObject("lisi", 25, 1192, new BigDecimal("123")));
        list.add(new SortedObject("wangwu", 25, 1299, new BigDecimal("59")));
        list.add(new SortedObject("zhaoliu", 25, 1192, new BigDecimal("89")));
        list.add(new SortedObject("quba", 25, 1192, new BigDecimal("1839")));
        //list.add(new SortedObject("quba",27,111,null));
        //list.add(new SortedObject("quba",null,111,null));
        //list.add(null);
        return list;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Test_Java8_01 t = new Test_Java8_01();
        t.method77();
    }

    public void method77(){

        ThreadClass03 tc1 = new ThreadClass03();
        ThreadClass03 tc2 = new ThreadClass03();
        Thread thread1 = new Thread(tc1,"线程1");
        Thread thread2 = new Thread(tc1,"线程2");
        thread1.start();
        thread2.start();


    }

    public void method76(){
        /*Test_Java8_01 t = new Test_Java8_01();
        Test_Java8_01 t1 = new Test_Java8_01();*/
       /* ThreadClass03 tc1 = new ThreadClass03();
        ThreadClass03 tc2 = new ThreadClass03();
        tc1.start();
        tc2.start();*/
    }

    public void method75(){

        ThreadClass02 threadClass02 = new ThreadClass02();

        Thread t1 = new Thread("aaaaaaaaaaaaaaaaa"){
            @Override
            public void run() {
                threadClass02.method01();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                threadClass02.method01();
            }
        };
        t1.start();
        t2.start();
    }

    public void method74(){

        ThreadClass02 tc1 = new ThreadClass02();
        //ThreadClass02 tc2 = new ThreadClass02();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                tc1.method04();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                tc1.method05();
            }
        };

        t1.start();
        t2.start();
    }

    public void method73(){

        ThreadClass02 tc1 = new ThreadClass02();
        Thread t2 = new Thread(tc1,"线程1~~~~~~");
        Thread t3 = new Thread(tc1,"线程2");
        t2.start();
        t3.start();
    }

    public void method72(){

        ThreadClass02 tc2 = new ThreadClass02();
        ThreadClass02 tc1 = new ThreadClass02();
        Thread t1 = new Thread(tc2,"t1~~");
        Thread t2 = new Thread(tc2,"t2");
        t1.start();
        t2.start();
    }

    public void method71(){

        Thread t1 = new Thread(new ThreadClass01(),"t1~~");
        t1.start();
        for (int i = 10000; i > 0; i--) {
            System.out.println(i);
        }

    }

    public void method70(){

        ClassMake cm1 = new ClassMake(0,"Ai~~");
        ClassMake cm2 = new ClassMake(1,"B");
        cm1.start();
        cm2.start();
    }

    public void method69() throws InterruptedException {

        // List<Integer> list = new ArrayList<>();
        // List<Integer> list = new Vector<>();
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 10000; i > 0; i--) {
            int a = i;
            new Thread(){
                @Override
                public void run() {
                    list.add(a);
                    /*synchronized (Test_Java8_01.class){
                        list.add(a);
                    }*/
                }
            }.start();
        }
        Thread.sleep(5000);
        System.out.println(list.size());
    }

    public void method68(){

        ThreadRunnableClass02 t = new ThreadRunnableClass02();
        Thread t1 = new Thread(t,"线程1");
        Thread t2 = new Thread(t,"线程2");
        Thread t3 = new Thread(t,"线程3");

        t1.start();
        t2.start();
        t3.start();
    }

    public void method67(){

        ReentrantLockClass rlc1 = new ReentrantLockClass();
        ReentrantLockClass rlc2 = new ReentrantLockClass();
        Thread t1 = new Thread(rlc1,"t1~~~");
        Thread t2 = new Thread(rlc1,"t2");

        t1.start();
        t2.start();
    }

    public void method66(){

        ThreadRunnableClass01 t1 = new ThreadRunnableClass01();

    }

    public void method65(){

        ThreadRunnableClass01 t1 = new ThreadRunnableClass01();
        ThreadRunnableClass01 t2 = new ThreadRunnableClass01();

        Thread thread1 = new Thread(t1,"thread1~~~");
        Thread thread2 = new Thread(t2,"thread2");

        thread1.start();
        thread2.start();
    }

    public void method64(){

        Test_Java8_01 t3 = new Test_Java8_01();
        //Test_Java8_01 t4 = new Test_Java8_01();

        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                t3.method64_1();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                t3.method64_1();
            }
        };

        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r2,"t2");

        t1.start();
        t2.start();

    }

    private synchronized void method64_1(){

        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread()+ ": "+i);
        }

    }

    public void method63(){

        Test_Java8_01 t = new Test_Java8_01();
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                t.method63_1();
            }
        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                t.method63_2();
            }
        };
        t1.start();
        t2.start();
    }

    private synchronized void method63_2(){
        System.out.println(Thread.currentThread()+": method63_2 开始执行");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException i){
            i.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": method63_2 执行完成");
    }

    private synchronized void method63_1(){
        System.out.println(Thread.currentThread()+"：method63_1 开始执行");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException i){
            i.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"：method63_1 执行完成");
    }

    public void method62(){

        ThreadRunnableClass01 t = new ThreadRunnableClass01();
        //ThreadRunnableClass01 tt = new ThreadRunnableClass01();
        Thread t1 =  new Thread(t,"t1");
        Thread t2 =  new Thread(t,"t2");

        t1.start();
        t2.start();

    }

    public void method61() {

        ThreadStopClass tsc = new ThreadStopClass();
        Thread thread = new Thread(tsc);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main " + i);
            if (i == 500) {
                tsc.stop(false); // 停止线程
                System.out.println("线程该停止了");
            }
        }

    }

    public void method60() {

        Thread t1 = new Thread("张安") {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread() + " " + i + " 救命");
                }
            }
        };

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread() + " 我来了");
                }
            }
        }, "例四");
        t2.setDaemon(true);

        t1.start();
        t2.start();

    }

    public void method59() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + " " + i);
                }
            }
        }, "AAA~~~");
        t1.setPriority(10);


        Thread t2 = new Thread("BBBB~~~~~~~~~~~~") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + " " + i);
                }
            }
        };
        System.out.println(t2.getPriority());

        t2.start();
        t1.start();

    }

    public void method58() {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + " " + i);
                }
            }
        };
        Thread thread = new Thread(r, "222");

        Thread t = new Thread("111") {
            @Override
            public void run() {
                String a = null;
                for (int i = 0; i < 100; i++) {
                    a = String.valueOf(i);
                    if (i == 50) {
                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        a += "1111111111111111111111111111";
                    }
                    System.out.println(Thread.currentThread() + " " + a);
                }
            }
        };

        t.start();
        thread.start();
    }

    public void method57() {

        Thread t = Thread.currentThread();
        t.setName("123");
        System.out.println(t.getName());

    }

    public void method56() {

        // 显示下载的进度
        Thread t = new Thread("666") {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + ":  " + "下载进度" + " " + i + " " + "%");
                }
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 100; i > 0; i--) {
                    System.out.println(Thread.currentThread() + ":  " + "显示进度" + " " + i + " " + "%");
                }
            }
        };
        Thread thread = new Thread(runnable, "999");

        t.start();
        thread.start();

    }

    public void method55() throws ExecutionException, InterruptedException {

        ThreadCallbaleClass tcc = new ThreadCallbaleClass();
        FutureTask<Integer> futureTask = new FutureTask<>(tcc);
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = futureTask.get();
        System.out.println(integer);

    }

    public void method54() {

        ThreadClass threadClass = new ThreadClass();
        threadClass.start();
        ThreadRunnableClass trc = new ThreadRunnableClass();
        Thread thread = new Thread(trc);
        thread.start();

    }

    public void method53() {

        LocalDate ld1 = LocalDate.of(2023, 8, 31);
        LocalDate ld2 = LocalDate.of(2024, 2, 15);
        Period p = Period.between(ld1, ld2);
        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());
    }

    public void method52() {

        LocalDate ldt1 = LocalDate.of(2024, 1, 1);
        LocalDate ldt2 = LocalDate.of(2025, 2, 11);
        Period period = Period.between(ldt1, ldt2);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());


    }

    public void method51() {

        /*LocalDate ldt1 = LocalDate.of(2024,1,1);
        LocalDate ldt2 = LocalDate.of(2023,1,2);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toDays()); // 相差的天数，天数取整会忽略时分秒
        System.out.println(duration.toHours()); // 相差的小时，小时取整会忽略分和秒
        System.out.println(duration.toMinutes()); // 相差的分钟数，分取整会忽略秒
        // 1秒 = 1000000000纳秒
        System.out.println(duration.toNanos()); // 纳秒
        // 1秒 = 1000毫秒
        System.out.println(duration.toMillis()); // 毫秒*/

        LocalTime lt1 = LocalTime.of(1, 1, 1);
        LocalTime lt2 = LocalTime.of(1, 1, 2);
        Duration duration1 = Duration.between(lt1, lt2);
        System.out.println(duration1.toMillis());
    }

    public void method50() {

        LocalDate with2 = LocalDate.parse("2022-04-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(with2); // 2022-04-13
        LocalDate with = with2.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(with); // 2022-12-31
    }

    public void method49() {

        LocalDate with2 = LocalDate.now()
                .with(TemporalAdjusters.firstDayOfYear()); // 获取当前年的第一天
        System.out.println(with2);

        LocalDate with3 = LocalDate.now()
                .with(TemporalAdjusters.lastDayOfYear()); // 获取当前年的最后一天
        System.out.println(with3);

        LocalDate with1 = LocalDate.now()
                .with(TemporalAdjusters.firstDayOfYear());
        LocalDate localDate = with1.plusMonths(13); // 对指定年月日的月值进行添加
        System.out.println(localDate);
    }

    public void method48() {

        // 年 月 日
        LocalDate ld = LocalDate.now();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dtf1.format(ld);
        System.out.println(format);

        // 年 月 日 时 分 秒
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = dtf2.format(ldt);
        System.out.println(format1);

        // 时 分 秒
        LocalTime lt = LocalTime.now();
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String format2 = dtf3.format(lt);
        System.out.println(format2);
    }

    public void method47() {

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(calendar.getTime());
        System.out.println(format);
    }

    public void method46() {

        LocalDate localDate1 = LocalDate.of(2024, 5, 11);
        LocalDate localDate2 = LocalDate.of(2024, 8, 12);
        Period p = Period.between(localDate1, localDate2);
        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());
    }

    public void method45() {

        LocalDate l = LocalDate.now();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format1 = dtf1.format(l);
        System.out.println(format1);

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf2.format(ldt);
        System.out.println(format);

        LocalTime lt = LocalTime.now();
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String format2 = dtf3.format(lt);
        System.out.println(format2);

    }

    public void method44() {

        InClass i = new InClass();
        // InterfaceImplementClass i = new InClass();
        //Interface01 i = new InClass();
        i.method01();

    }

    public void method43() {

        List<SortedObject> so
                = getSortedObject();
        //      = null;
        List<SortedObject> list = Optional.ofNullable(so).filter(s -> {
            List<Integer> collect = s.stream().map(sos -> sos.getAge()).filter(o -> o > 10).collect(Collectors.toList());
            System.out.println(collect);
            return Optional.ofNullable(collect).isPresent();
        }).get();
        System.out.println(list);
    }

    public void method42() {

        List<SortedObject> so
                //        = getSortedObject();
                = null;
        Optional.ofNullable(so).ifPresent(s -> {
            List<Integer> collect = s.stream().map(SortedObject::getNumber).collect(Collectors.toList());
            System.out.println(collect);
        });

        Object o = Optional.ofNullable(null).orElseGet(() -> new Emp("1", 2, new BigDecimal("1")));
        System.out.println(o);

    }

    public void method41() {

        Optional<Emp> o = Optional.of(new Emp());
        System.out.println(o);
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        Emp emp = new Emp();
        Optional<Emp> emp1 = Optional.ofNullable(emp);
        System.out.println(emp1);
        Emp emp2 = emp1.orElse(new Emp("1", 2, new BigDecimal(3)));
        System.out.println(emp2);
        boolean present = emp1.isPresent();
        System.out.println(present);
        emp1.ifPresent(emp3 -> emp3.setName("123"));
        System.out.println(emp);


    }

    public void method40() {

        List<SortedObject> so = getSortedObject();
        Integer integer = so.stream().map(s -> 1).reduce((a, b) -> a + b).orElseGet(() -> 0);
        System.out.println(integer);
    }

    public void method39() {

        List<SortedObject> so = getSortedObject();
        Integer collect = so.stream().map(SortedObject::getAge).collect(Collectors.summingInt(Integer::intValue));
        Integer collect1 = so.stream().collect(Collectors.summingInt(SortedObject::getAge));
        long sum = so.stream().collect(Collectors.summarizingInt(SortedObject::getAge)).getSum();
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(sum);
    }

    public void method38() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> collect = list.stream().map(n -> Math.pow(n, 2)).collect(Collectors.toList());
        System.out.println(collect);

    }

    public void method37() {

        List<Emp> emp = getEmp();
        Stream<String> stream = emp.stream().map(Emp::getName);
       /* String collect = stream.collect(Collectors.joining());
        System.out.println(collect);*/
        /*String collect1 = stream.collect(Collectors.joining(","));
        System.out.println(collect1);*/
        String collect2 = stream.collect(Collectors.joining(",", "前缀", "后缀"));
        System.out.println(collect2);
    }

    public void method36() {

        List<SortedObject> sortedObject = getSortedObject();
        IntSummaryStatistics collect = sortedObject.stream().collect(Collectors.summarizingInt(SortedObject::getAge));
        System.out.println(collect.getSum());
        System.out.println(collect.getMin());
        System.out.println(collect.getAverage());

    }

    public void method35() {

        List<Integer> list = Arrays.asList(78, 3, 6, 9, 66);
        list.stream().forEach(e -> System.out.println(e));
        System.out.println("--------------------------------");
        list.stream().forEachOrdered(e -> System.out.println(e));
        System.out.println("--------------------------------");
        list.parallelStream().forEach(e -> System.out.println(e));
        System.out.println("--------------------------------");
        list.parallelStream().forEachOrdered(e -> System.out.println(e));

    }

    public void method34() {

        List<SortedObject> sortedObject = getSortedObject();
        Map<Boolean, List<SortedObject>> collect = sortedObject
                .stream()
                .collect(
                        Collectors.partitioningBy(sortedObject1 -> sortedObject1.getAge().equals(10)));
        System.out.println(collect);

    }

    public void method33() {

        List<SortedObject> so = getSortedObject();
        Map<Integer, Map<Integer, List<SortedObject>>> collect =
                so.stream().collect(Collectors.groupingBy(SortedObject::getAge, Collectors.groupingBy(SortedObject::getNumber)));
        Set<Map.Entry<Integer, Map<Integer, List<SortedObject>>>> entries = collect.entrySet();
        Iterator<Map.Entry<Integer, Map<Integer, List<SortedObject>>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void method32() {

        List<Emp> emp = getEmp();
        /*Map<BigDecimal, List<Emp>> collect = emp.stream().collect(Collectors.groupingBy(Emp::getSla));
        Set<Map.Entry<BigDecimal, List<Emp>>> entries = collect.entrySet();
        Iterator<Map.Entry<BigDecimal, List<Emp>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //System.out.println(collect);

        Map<BigDecimal, Long> collect1 = emp.stream().collect(Collectors.groupingBy(Emp::getSla, Collectors.counting()));
        System.out.println(collect1);

        Long collect2 = emp.stream().collect(Collectors.counting());
        System.out.println(collect2);

        Map<BigDecimal, List<Emp>> collect3 = emp.stream().collect(Collectors.groupingBy(Emp::getSla, Collectors.toList()));
        System.out.println(collect3);*/

        Map<String, List<Emp>> collect4 = emp.stream().collect(Collectors.groupingBy(e -> {
            if (e.getAge() <= 30) {
                return "yun";
            } else if (e.getAge() >= 30 && e.getAge() <= 50) {
                return "str";
            } else {
                return "old";
            }
        }));
        Set<Map.Entry<String, List<Emp>>> entries1 = collect4.entrySet();
        Iterator<Map.Entry<String, List<Emp>>> iterator = entries1.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Emp>> next = iterator.next();
            System.out.println(next.getKey() + " - " + next.getValue());
        }
    }

    public void method31() {

        List<Emp> emp = getEmp();
        Integer integer = emp.stream().map(Emp::getAge).collect(Collectors.minBy((a1, a2) -> a1 - a2)).get();
        System.out.println(integer);
        Emp emp2 = emp.stream().collect(Collectors.minBy((e1, e2) -> e1.getAge() - e2.getAge())).get();
        System.out.println(emp2);
        Emp emp1 = emp.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge())).get();
        System.out.println(emp1);
        Double collect = emp.stream().collect(Collectors.averagingInt(Emp::getAge));
        System.out.println(collect);
        Integer collect1 = emp.stream().collect(Collectors.summingInt(Emp::getAge));
        System.out.println(collect1);
        /*long count = emp.stream().count();
        List<Integer> collect = emp.stream().map(Emp::getAge).collect(Collectors.toList());
        System.out.println(count);
        System.out.println(collect);
        Double collect1 = emp.stream().map(Emp::getAge).collect(Collectors.averagingInt(e->e));
        System.out.println(collect1);
*/
    }

    public void method30() {

        List<Emp> emp = getEmp();
        ConcurrentMap<String, Emp> collect = emp.stream().collect(Collectors.toConcurrentMap(Emp::getName,
                emp1 -> emp1,
                (ov, nv) -> ov));
        System.out.println(collect);
    }

    public void method29() {

        List<Emp> emp = getEmp();
        List<Integer> collect1 = emp.stream().map(e -> e.getAge()).collect(Collectors.toList());
        Set<Integer> collect2 = emp.stream().map(e -> e.getAge()).collect(Collectors.toSet());
        HashSet<Integer> s = emp.stream().map(e -> e.getAge()).collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(s);

    }

    public void method28() {

        // 字符串拼接
        List<SortedObject> list = getSortedObject();
        String s = list.stream().map(e -> e.getName()).reduce((t, u) -> t + "-" + u).get();
        System.out.println(s);
        // 求和
        Integer integer = list.stream().map(e -> e.getAge()).reduce((t, u) -> Integer.sum(t, u)).get();
        System.out.println(integer);

    }

    public void method27() {

        List<SortedObject> list = getSortedObject();
        //boolean b = list.stream().map(e -> e.getAge()).noneMatch(e -> e.compareTo(2) == 0);
        Integer integer = list.stream().map(e -> e.getAge()).findFirst().get();
        System.out.println(integer);

    }

    public void method26() {

        List<Emp> emp = getEmp();
        long count = emp.stream().count();
        System.out.println(count);
        BigDecimal bigDecimal = emp.stream().map(e -> e.getSla()).max(BigDecimal::compareTo).get();
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = emp.stream().map(e -> e.getSla()).reduce(BigDecimal::add).get();
        System.out.println(bigDecimal1);

    }

    public void method25() {

        List<String> list = Arrays.asList("22", "19", "89", "90");
        IntStream intStream = list.stream().mapToInt(s -> Integer.parseInt(s));
        //int asInt = intStream.reduce((l, r) -> l + r).getAsInt();
        int sum = intStream.sum();
        System.out.println(sum);

    }

    public void method24() {

        List<SortedObject> list = getSortedObject();
        /*list.sort(Comparator.comparing(SortedObject::getAge)
                .thenComparing(SortedObject::getMoney,Comparator.reverseOrder()));*/

        list.stream().sorted(
                        Comparator.comparing(SortedObject::getAge)
                                .thenComparing(SortedObject::getMoney, Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e));

        /*for (SortedObject sortedObject : list) {
            System.out.println(sortedObject);
        }*/
        //list.stream().sorted(Comparator.comparing(SortedObject::getMoney,Comparator.reverseOrder())).forEach(e-> System.out.println(e));

    }

    public void method23() {

        List<Emp> emp = getEmp();
        emp.stream().sorted(Comparator.comparing(Emp::getAge, Comparator.reverseOrder())).forEach(e -> {
            System.out.println(e);
        });

        List<Integer> list = Arrays.asList(12, 3, 5, 12, 2534, 45, 1);
        List<Integer> collect = list.stream().sorted(Comparator.comparing(Integer::intValue, Comparator.reverseOrder())).collect(Collectors.toList());
        /*List<Integer> collect = list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }).collect(Collectors.toList());*/
        System.out.println(collect);


        //List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        //System.out.println(collect);

    }

    public void method22() {

        List<String> l1 = Arrays.asList("https://", "www", ".", "java", ".", "cn");
        List<String> l2 = Arrays.asList("公众号", ":", "456");
        List<String> l3 = Arrays.asList("作者", ":", "123");
        List<List<String>> all = new ArrayList<>();
        all.add(l1);
        all.add(l2);
        all.add(l3);
        List<String> collect = all.stream().flatMap(l -> l.stream().map(e -> e + "-=-=")).collect(Collectors.toList());
        System.out.println(collect);
    }

    public void method21() {

        List<String> list = Arrays.asList("https://", "www", ".", "javastack", ".", "cn");
        List<String> collect = list.stream().map(e -> e + "--").collect(Collectors.toList());
        System.out.println(collect);

    }

    public void method20() {

        List<Emp> emp = getEmp();
        Stream<Emp> stream = emp.stream();
        List<Integer> collect = stream.distinct().map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println(collect);

        // skip
        //stream.skip(5).forEach(emp1 -> System.out.println(emp1));
        // limit
        /*List<Emp> collect1 = stream.limit(5).collect(Collectors.toList());
        System.out.println(collect1);*/
        // filter
       /* List<Emp> collect = emp.stream().filter(e -> e.getAge() <= 35).collect(Collectors.toList());
        System.out.println(collect);*/

        /*emp.stream().forEach(emp1 -> {
            System.out.println(emp1);
        });*/

    }

    public void method19() {

        Comparator<Integer> co = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = co.compare(100, 20);
        System.out.println(compare);

        Math.random();

        Supplier<Emp> s = Emp::new;
        Emp emp = s.get();
        Integer age = emp.getAge();

    }

    // 特殊的方法引用
    public void method18() {

        // 例一：第一个参数是String类的equals(...)实例方法的调用者，而第二个参数是实例方法的参数
        BiPredicate<String, String> b1 = (x, y) -> x.equals(y);
        boolean test = b1.test("a", "a");
        System.out.println(test);

        BiPredicate<String, String> b2 = String::equals;
        boolean test1 = b2.test("c", "c");
        System.out.println(test1);

        // 例二：参数s是String类的isEmpty()实例方法调用者
        Predicate<String> p = s -> s.isEmpty();
        boolean t3 = p.test("234");

        Predicate<String> p2 = String::isEmpty;
        boolean t4 = p.test("234");

        // 例三：参数s是String类的toUpperCase()实例方法调用者
        Function<String, String> f1 = s -> s.toUpperCase();
        Function<String, String> f2 = String::toUpperCase;

        // 例三：自定义，参数emp是Emp类的getName实例方法调用者
        Function<Emp, String> fu1 = emp -> emp.getName();
        Function<Emp, String> fu2 = Emp::getName;
    }

    // 实例方法引用
    public void method17() {

        Emp e = new Emp();
        // 供给型
        Supplier<Integer> s = e::supplierM;
        Integer integer = s.get();
        System.out.println(integer);
        Supplier<Integer> s1 = e::getAge;
        System.out.println(s1);

        // 函数式
        Function<String, Integer> f = e::functionM;
        Integer apply = f.apply("122");
        System.out.println(apply);

        // 断定行
        Predicate<String> pre = e::predicateM;
        boolean p = pre.test("非空");
        System.out.println(p);

        // 消费型
        Consumer<String> c1 = e::consumerM;
        c1.accept("100");
        Consumer<String> c2 = e::setName;
        c1.accept("666");
        Test_Java8_01 t = new Test_Java8_01();
        t.method17_1("你好", e::consumerM);
        t.method17_1("100", e::functionM); // 抽象方法没有返回值，方法可以有返回值
    }

    private void method17_1(String s, Consumer<String> c) {
        c.accept(s);
    }

    public void method16() {

        List<Emp> emp = getEmp();
        Collections.sort(emp, Comparator.comparing(Emp::getAge));
        for (Emp e : emp) {
            System.out.println(e);
        }

    }

    public void method15() {

        Test_Java8_01 t = new Test_Java8_01();
        Boolean aBoolean = t.method15_1("asdf", s -> {
            if (s != null && s.length() > 0) {
                return true;
            } else {
                return false;
            }
        });
        System.out.println(aBoolean);
    }

    private Boolean method15_1(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    public void method14() {

        Test_Java8_01 t = new Test_Java8_01();
        Integer integer = t.method14_1("123", s -> {
            if (s != null && s.length() > 0) {
                return Integer.parseInt(s);
            }
            return null;
        });
        System.out.println(integer);
    }

    private Integer method14_1(String s, Function<String, Integer> f) {

        return f.apply(s);
    }

    public void method13() {

        Test_Java8_01 t = new Test_Java8_01();
        String s = t.method13_1(() -> "12rqwe3");
        System.out.println(s);

    }

    private String method13_1(Supplier<String> supplier) {

        return supplier.get();
    }

    public void method12() {

        Test_Java8_01 t = new Test_Java8_01();
        t.method12_1("1231", s -> System.out.println(s));

    }

    // 消费型接口
    private void method12_1(String s, Consumer<String> consumer) {
        consumer.accept(s);
    }

    public void method11() {

        Test_Java8_01 t = new Test_Java8_01();
        Integer integer = t.method11_1(10, 10, (t1, t2) -> t1 * t2);
        System.out.println(integer);

    }

    private Integer method11_1(Integer i1, Integer i2, FunctionInterfaceTR<Integer, Integer> f) {

        return f.getR(i1, i2);
    }

    public void method10() {

        /*FunctionInterfaceTR<Integer,Integer> fi = (t1,t2)->t1*t2;
        Integer r = fi.getR(10, 10);
        System.out.println(r);*/

        FunctionInterfaceTR<Integer, Integer> f = (t1, t2) -> t1 + t2;
        Integer r = f.getR(10, 10);
        System.out.println(r);

    }

    public void method09() {

        Test_Java8_01 t1 = new Test_Java8_01();
        //String s1 = t1.method09_1("你好我好大家好", s -> s.substring(2, 5));
        String s2 = t1.method09_1("asd", s -> s.toUpperCase());
        System.out.println(s2);

    }

    private String method09_1(String s, FunctionInterfaceString<String> fic) {

        return fic.getStr(s);
    }

    public void method08() {

        //FunctionInterfaceString<String> fic = s -> s.toUpperCase();
        FunctionInterfaceString<String> fic = s -> s.substring(2, 5);
        String asd = fic.getStr("123456789");
        System.out.println(asd);

    }

    public void method07() {

        List<Emp> emp = getEmp();
        // Collections.sort(emp, Comparator.comparing(Emp::getAge).thenComparing(Emp::getSla));
        emp.sort((e1, e2) -> {
            if (e1.getAge().compareTo(e2.getAge()) != 0) {
                return e1.getAge().compareTo(e2.getAge());
            } else {
                return e1.getSla().compareTo(e2.getSla());
            }
        });
        for (Emp emp1 : emp) {
            System.out.println(emp1);
        }

    }

    public void method06() {

        FunctionInterfaceVoid fic = (a, b) -> {
            a = (int) (a) + 10;
            b = b.toString();
            System.out.println(a + " " + b);
            return a + "" + b;
        };
        String str = fic.method(10, "str");
        System.out.println(str);
    }

    public void method05() {

        List<Emp> pan = AllCeInter.pan(emp -> emp.getAge() >= 35, getEmp());
        System.out.println(pan);
    }

    public void method04() {

        List<Emp> pan = AllCeInter.pan(new CeInter<Emp>() {
            @Override
            public Boolean test(Emp e) {
                if (e.getAge().compareTo(35) >= 0) {
                    return true;
                }
                return false;
            }
        }, getEmp());
        System.out.println(pan);

    }

    public void method03() {

        List<Emp> pan = AllCeInter.pan(new Ce5000(), getEmp());
        System.out.println(pan);
    }

    public void method02() {

        List<Emp> emp = getEmp();
        List<Emp> list = new ArrayList<>();
        for (Emp emp1 : emp) {
            if (emp1.getSla().compareTo(new BigDecimal("5000")) >= 0) {
                list.add(emp1);
            }
        }
        System.out.println(list);
    }

    public void method01() {

        List<Emp> list = new ArrayList<>();
        list.add(new Emp("张三", 21, new BigDecimal(3500)));
        list.add(new Emp("李四", 18, new BigDecimal(3000)));
        list.add(new Emp("王五", 54, new BigDecimal(10000)));
        list.add(new Emp("赵六", 35, new BigDecimal(5000)));
        list.add(new Emp("田七", 44, new BigDecimal(7000)));
        list.add(new Emp("王八", 24, new BigDecimal(7000)));
        List<Emp> list35 = new ArrayList<>();
        for (Emp emp : list) {
            if (emp.getAge().compareTo(35) >= 0) {
                list35.add(emp);
            }
        }
        System.out.println(list35);

    }

}
