package com.cui.cn.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-12:45
 */
public class EmpTest {

    public static void main(String[] args) {

        EmpTest et = new EmpTest();
        et.method25();
    }

    public List<Emp> listEmp() {
        List<Emp> list = new ArrayList<>();
        list.add(new Emp("张三", 21, new BigDecimal(3500), 4));
        list.add(new Emp("李四", 18, new BigDecimal(3000), 4));
        list.add(new Emp("王五", 54, new BigDecimal(10000), 2));
        list.add(new Emp("赵六", 35, new BigDecimal(5000), 3));
        list.add(new Emp("田七", 44, new BigDecimal(7000), 3));
        list.add(new Emp("王八", 24, new BigDecimal(7000), 3));
        list.add(new Emp("王1", 25, new BigDecimal(71000), 1));
        list.add(new Emp("王2", 26, new BigDecimal(71000), 1));
        list.add(new Emp("王3", 24, new BigDecimal(7000), 3));
        return list;
    }

    public void method25(){

        List<Emp> emps = listEmp();
        List<Emp> list = new ArrayList<>();
        for (Emp emp : emps) {
            Integer age = emp.getAge();
            if(age.compareTo(35)>0){
                list.add(emp);
            }
        }
        System.out.println(list);

        /*List<Emp> collect = emps.stream().filter(e -> e.getAge() > 35).collect(Collectors.toList());
        System.out.println(collect);*/

    }

    public void method24(){

        FlatMapTest fmt = new FlatMapTest();
        // 不需要像map一样通过底层
        Optional<String> s = Optional.ofNullable(fmt).flatMap(flatMapTest -> flatMapTest.getDesc());
        System.out.println(s);

    }

    public void method23(){

        List<Emp> emps = listEmp();

        boolean present = Optional.ofNullable(new Emp()).isPresent();
        Emp as = Optional.ofNullable(new Emp()).map(e -> {
            e.setMoney(new BigDecimal(100));
            e.setZhiji(1);
            e.setAge(89);
            e.setName("as");
            return e;
        }).get();
        System.out.println(as);
        System.out.println(present);
        /*List<String> list = Optional.ofNullable(emps).map(e -> {
            List<String> collect = e.stream().map(wp -> wp.getName()).collect(Collectors.toList());
            return collect;
        }).get();
        Optional.ofNullable(emps).flatMap(e->{
            return Optional.ofNullable(e);
        }).get();
        System.out.println(list);*/

    }

    public void method22(){

        List<Emp> emps = listEmp();
        Optional<List<Emp>> empsOptional = Optional.ofNullable(emps);
        if (empsOptional.isPresent()) {
            Optional<List<Emp>> emps1 = empsOptional.filter(o -> true);
            System.out.println(emps1.isPresent());
            System.out.println(emps1.get());
        }else{
            empsOptional.orElse(new ArrayList<>());
        }

    }

    public void method21(){

        List<Emp> emps =null;// listEmp();
        Optional<List<Emp>> emps2 = Optional.ofNullable(emps);
        //Optional.ofNullable(emps).orElseThrow()
        if(emps2.isPresent()){
            System.out.println("非null");
        }else{
            //List<Emp> emps1 = emps2.orElse(new ArrayList<>());
            List<Emp> emp = new ArrayList<>();
            List<Emp> emps1 = emps2.orElseGet(() -> {
               emp.add(new Emp());
                return emp;
            });
            System.out.println(emps1);
        }
        /*Optional.ofNullable(emps).ifPresent(emps1 -> {
            List<String> collect = emps1.stream().map(e -> e.getName()).collect(Collectors.toList());
            System.out.println(collect);
        });*/
    }

    public void method20(){

        /*Optional<Emp> empty = Optional.empty();
        System.out.println(empty.get());*/
        Emp emp1 = null;
        Emp emp2 = new Emp();
        Optional<Emp> o = Optional.ofNullable(emp2);
        boolean present = o.isPresent();
        System.out.println(present);
        System.out.println(o.orElse(new Emp()));
    }

    public void method19(){

        List<Emp> emps = listEmp();
        IntSummaryStatistics collect = emps.stream().collect(Collectors.summarizingInt(Emp::getAge));
        System.out.println(collect.getMin());
        System.out.println(collect.getSum());
    }

    public void method18(){

        List<Emp> emps = listEmp();
        Map<Boolean, List<Emp>> collect = emps.stream().collect(Collectors.partitioningBy(e -> {
            return e.getAge() > 35;
        }));
        Set<Map.Entry<Boolean, List<Emp>>> entries = collect.entrySet();
        Iterator<Map.Entry<Boolean, List<Emp>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Boolean, List<Emp>> next = iterator.next();
            System.out.println(next.getKey()+"  "+next.getValue());
        }

        /*Map<Integer, Map<String, List<Emp>>> collect = emps.stream().collect(Collectors.groupingBy(Emp::getZhiji, Collectors.groupingBy(e -> {
            if (e.getAge() > 35) {
                return "comme";
            } else {
                return "yng";
            }
        })));
        Set<Map.Entry<Integer, Map<String, List<Emp>>>> entries = collect.entrySet();
        Iterator<Map.Entry<Integer, Map<String, List<Emp>>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Map<String, List<Emp>>> next = iterator.next();
            System.out.println(next.getKey() +" " +next.getValue());
        }*/

        /*Map<Integer, List<Emp>> collect = emps.stream().collect(Collectors.groupingBy(Emp::getZhiji));
        Set<Map.Entry<Integer, List<Emp>>> entries = collect.entrySet();
        Iterator<Map.Entry<Integer, List<Emp>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Emp>> next = iterator.next();
            System.out.println(next.getKey() + " = " +next.getValue());
        }*/

    }

    public void method17(){
        List<Emp> emps = listEmp();
        Long collect = emps.stream().map(e -> e.getMoney()).collect(Collectors.counting());
        System.out.println(collect);
        BigDecimal bigDecimal = emps.stream().map(e -> e.getMoney()).reduce(BigDecimal::add).get();
        Integer collect1 = emps.stream().map(e -> e.getAge()).collect(Collectors.summingInt(e -> e));
        System.out.println(collect1);
        Integer collect2 = emps.stream().collect(Collectors.summingInt(Emp::getAge));
        System.out.println(collect2);
        Double collect3 = emps.stream().collect(Collectors.averagingInt(Emp::getAge));
        System.out.println(collect3);
        Emp emp = emps.stream().collect(Collectors.maxBy((e1, e2) -> e1.getMoney().compareTo(e2.getMoney()))).get();
        System.out.println(emp);
    }

    public void method16(){

        List<Emp> emps = listEmp();
        Map<Integer, Emp> collect = emps.stream().collect(Collectors.toMap(
                e -> {
                    System.out.println(e);
                    return e.getAge();
                },
                e -> e,
                (oldValue,newValue)->{
                    return newValue;
                }
        ));
        Set<Map.Entry<Integer, Emp>> entries = collect.entrySet();
        Iterator<Map.Entry<Integer, Emp>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Emp> next = iterator.next();
            System.out.println(next.getKey() + "---" +next.getValue());
        }


        /*emps.stream().forEach((e)-> System.out.println(e));
        System.out.println("----------");
        emps.parallelStream().forEach((e)-> System.out.println(e));
*/
    }

    public void method15(){

        List<Emp> emps = listEmp();
        Set<BigDecimal> collect = emps.stream().map(e -> e.getMoney()).collect(Collectors.toSet());
        System.out.println(collect);

    }

    public void method14(){

        List<Emp> emps = listEmp();
        BigDecimal bigDecimal = emps.stream().map(e -> e.getMoney()).reduce(BigDecimal::add).get();
        System.out.println(bigDecimal);
    }

    public void method13(){

        List<String> list1 = new ArrayList<>();
        list1.add("A1");
        list1.add("A2");
        list1.add("A3");
        List<String> list2 = new ArrayList<>();
        list2.add("B1");
        list2.add("B2");
        list2.add("B3");
        List<String> list3 = new ArrayList<>();
        list3.add("C1");
        list3.add("C2");
        list3.add("C3");
        List<String> list4 = new ArrayList<>();
        list4.add("D1");
        list4.add("d2");
        list4.add("d3");
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        List<String> collect = Optional.ofNullable(list).flatMap(lists -> Optional.ofNullable(lists.stream().map(e -> e + "-1"))).get().collect(Collectors.toList());
        System.out.println(collect);

    }

    public void method12(){

        List<Emp> emps = listEmp();
        List<Emp> collect = emps.stream()
                .sorted(
                        Comparator.comparing(Emp::getMoney)
                                .thenComparing(Comparator.comparing(Emp::getAge,Comparator.nullsFirst(Integer::compareTo))))
                .collect(Collectors.toList());
        System.out.println(collect);
        for (Emp emp : collect) {
            System.out.println(emp);
        }
    }

    public void method11(){

        List<Emp> emps = listEmp();

        Integer integer = emps.stream().map(e -> e.getZhiji()).reduce((s1, s2) -> {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(s1));
            stringBuffer.append(s2);
            return s1+s2;
        }).get();
        System.out.println(integer);

        /*long count = emps.stream().map(e->e.getMoney()).count();
        System.out.println(count);
        BigDecimal bigDecimal = emps.stream().map(e -> e.getMoney()).min(BigDecimal::compareTo).get();
        System.out.println(bigDecimal);

        boolean b = emps.stream().map(e -> e.getMoney()).noneMatch(p -> p.compareTo(new BigDecimal("128999")) >= 0);
        System.out.println(b);
        BigDecimal bigDecimal1 = emps.stream().map(e -> e.getMoney()).findAny().get();
        System.out.println(bigDecimal1);
        BigDecimal bigDecimal2 = emps.stream().map(e -> e.getMoney()).reduce(BigDecimal::add).get();
        System.out.println(bigDecimal2);*/

    }

    public void method10(){

        List<String> list = Arrays.asList("22", "19", "89", "90");
        List<Integer> collect = list.stream().mapToInt(s -> {
            return Integer.parseInt(s);
        }).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }

    public void method09() {

        List<Emp> emps = listEmp();
        List<Emp> collect = emps.stream().sorted((e1, e2) -> {
            if (e1.getMoney().compareTo(e2.getMoney()) == 0) {
                return -(e1.getAge() - e2.getAge());
            } else {
                return e1.getMoney().compareTo(e2.getMoney());
            }
        }).collect(Collectors.toList());
        /*List<Emp> collect = emps.stream()
                .sorted(Comparator.comparing(Emp::getMoney)
                        .thenComparing(Comparator.comparing(Emp::getAge,Comparator.nullsLast(Integer::compareTo)).reversed()))
                .collect(Collectors.toList());*/
        //System.out.println(collect);
        // 方式二：多字段排序
        //Collections.sort(emps, Comparator.comparing(Emp::getMoney).thenComparing(Comparator.comparing(Emp::getAge).reversed()));
        //emps.sort(Comparator.comparing(Emp::getZhiji).reversed());
        // 方式一：单字段排序
        //Collections.sort(emps,(e1,e2)->e1.getAge()-e2.getAge());
        for (Emp emp : collect) {
            System.out.println(emp);
        }
    }

    /**
     * map 和 flatMap
     */
    public void method08()/* throws NoSuchMethodException, InvocationTargetException, IllegalAccessException*/ {

        List<String> list1 = new ArrayList<>();
        list1.add("A1");
        list1.add("A2");
        list1.add("A3");
        List<String> list2 = new ArrayList<>();
        list2.add("B1");
        list2.add("B2");
        list2.add("B3");
        List<String> list3 = new ArrayList<>();
        list3.add("C1");
        list3.add("C2");
        list3.add("C3");
        List<String> list4 = new ArrayList<>();
        list4.add("D1");
        list4.add("d2");
        list4.add("d3");
        List<List> listA = new ArrayList<>();
        listA.add(list1);
        listA.add(list2);
        //listA.stream().flatMap(list -> list.stream().map(s->s)).forEach(s-> System.out.println(s));
        List<List> listB = new ArrayList<>();
        listB.add(list3);
        listB.add(list4);
        List<List> listListAll = new ArrayList<>();
        listListAll.add(listA);
        listListAll.add(listB);
        //listListAll.stream().flatMap(li->li.stream().map(m->m)).forEach(s-> System.out.println(s));

        // fanxing
        /*Class<? extends List> aClass = list1.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list1, true);
        add.invoke(list1, 123);
        add.invoke(list1, "true");
        System.out.println(list1);*/
    }

    public void method07(){

        List<Emp> emps = listEmp();
        //emps.stream().peek(e -> e.setMoney(e.getMoney().add(new BigDecimal("100")))).forEach(e-> System.out.println(e));
        emps.stream().map(e->{
            e.setMoney(e.getMoney().add(new BigDecimal("10")));
            return e;
        }).forEach(e-> System.out.println(e));


        /*Stream<Emp> peek = emps.stream().peek(e -> e.setZhiji(1));
        Stream<BigDecimal> bigDecimalStream = emps.stream().map(e -> e.getMoney());*/

        //emps.stream().filter(e->e.getZhiji()<=2 || e.getMoney().compareTo(new BigDecimal(7000))>=0).forEach(e-> System.out.println(e));

        /*List<Emp> mapE = new ArrayList<>();
        emps.stream().distinct().map(e->{
            return mapE.add(new Emp(e.getMoney(),e.getZhiji()));
        }).forEach(e-> System.out.println(e));
        System.out.println(mapE);*/
        //emps.stream().skip(5).forEach(e-> System.out.println(e));
        //emps.stream().filter(e->e.getMoney().compareTo(new BigDecimal("8000"))>=0).forEach(e-> System.out.println(e));
        //emps.stream().limit(5).forEach(e-> System.out.println(e));
    }

    public void method06(){

        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        iterate.limit(10).forEach(x-> System.out.println(x));

        List<Double> collect = Stream.generate(() -> Math.random()).limit(10).collect(Collectors.toList());
        System.out.println(collect);

        /*Stream<String> stream = Stream.of("s","2");

        String [] str = new String[10];
        Stream<String> stream1 = Arrays.stream(str);

        List<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream();*/
    }

    public void method05() {

        String s = "fdassDfdasdfFDAFafa";

        String s2 = LambdaFunctionImplement01.utilMethod(s, (s1) -> {
            return s1.toUpperCase();
        });
        System.out.println(s2);

        LambdaFunction01 l1 = str -> str.toUpperCase();
        String value = l1.getValue(s);
        System.out.println(value);

        LambdaFunction01 l2 = str -> {
            StringBuffer sb = new StringBuffer("第二个字符为：");
            sb.append(str.charAt(1));
            sb.append("第四个参数为："+str.charAt(3));
            return sb.toString();
        };
        String value1 = l2.getValue(s);
        System.out.println(value1);

        /*List<Emp> emps = listEmp();
        List<Emp> data = CelveUtil.getData(emps, e -> {
            return e.getAge() > 35;
        });
        System.out.println(data);*/
    }

    public void method04() {
        List<Emp> emps = listEmp();
        Collections.sort(emps, (e1, e2) -> {
            return e1.getZhiji() - e2.getZhiji();
        });
        /*Collections.sort(emps, (e1,e2)->
             e1.getZhiji() - e2.getZhiji()

                *//*new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.getZhiji() - o2.getZhiji();
            }
        }*//*);*/
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    public void method03() {

        List<Emp> data = CelveUtil.getData(listEmp(), (e) -> {
            return e.getAge() >= 35;
        });

        System.out.println(data);
    }

    public void method02() {

        List<Emp> data = CelveUtil.getData(listEmp(), new CeLve<Emp>() {
            @Override
            public Boolean getDataByData(Emp emp) {
                return emp.getZhiji() <= 2;
            }
        });
        System.out.println(data);

    }

    public void method01() {

        List<Emp> data1 = CelveUtil.getData(listEmp(), new SlaBigEq5000());
        System.out.println(data1);
        List<Emp> data2 = CelveUtil.getData(listEmp(), new AgeBig35());
        System.out.println(data2);
    }

    public void getEmpSla5000() {

        List<Emp> emps = listEmp();
        List<Emp> list = new ArrayList<>();
        for (Emp emp : emps) {
            if (emp.getMoney().compareTo(new BigDecimal("5000")) >= 0) {
                list.add(emp);
            }
        }
        System.out.println(list);

    }

    public List<Emp> getEmpMax35() {

        List<Emp> emps = listEmp();
        List<Emp> list = new ArrayList<>();
        for (Emp emp : emps) {
            if (emp.getAge() > 35) {
                list.add(emp);
            }
        }
        return list;
    }

}
