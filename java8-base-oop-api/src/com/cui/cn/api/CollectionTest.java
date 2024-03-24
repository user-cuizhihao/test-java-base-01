package com.cui.cn.api;

import java.util.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-22-6:59
 */
public class CollectionTest {

    public static void main(String[] args) {

        CollectionTest c = new CollectionTest();
        c.method08();

//        c.method04();
//        c.method03();
//        c.method01();

    }

    // 栈
    public void method08(){

        Deque<Integer> stack = new LinkedList<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    // 双端队列
    public void method07(){

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(12);
        deque.offerFirst(13);
        deque.offerLast(11);
        deque.offer(10);
        deque.offerLast(89);
        deque.offerFirst(19);
        deque.offer(78);
        System.out.println(deque);

    }

    // 队列
    public void method06(){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(12);
        queue.offer(13);
        queue.offer(11);
        queue.offer(10);
        System.out.println(queue);
        System.out.println(queue.size());
        while (queue.size() > 0){
            System.out.println(queue.poll());
        }
        System.out.println(queue);
    }

    public void method05(){

        List<SortBean> list = new ArrayList<>();
        list.add(new SortBean(3,21,"你好","描述3"));
        list.add(new SortBean(2,11,"你好2","描述3"));
        list.add(new SortBean(77,21,"你好77","描述3"));
        list.add(new SortBean(null,21,"你好77","描述3"));
        list.add(new SortBean(66,11,"你好66","描述3"));
        list.add(new SortBean(76,23,"你好76","描述3"));
        list.add(new SortBean(76,null,"你好76","描述3"));
        list.add(new SortBean(76,22,"你好76","描述3"));
        list.add(new SortBean(1,24,"你好1","描述3"));
        list.sort(Comparator.comparing(SortBean::getAge,Comparator.nullsFirst(Integer::compareTo))
                .thenComparing(Comparator.comparing(SortBean::getId,Comparator.nullsLast(Integer::compareTo))));
        for (SortBean sortBean : list) {
            System.out.println(sortBean);
        }

        /*System.out.println(list);
        list.sort(Comparator.comparing(SortBean::getId).reversed());
        for (SortBean sortBean : list) {
            System.out.println(sortBean);
        }*/

        /*Collections.sort(list, new Comparator<SortBean>() {
            @Override
            public int compare(SortBean o1, SortBean o2) {
                return -(o1.getId() - o2.getId());
            }
        });*/

        /*Collections.sort(list,(o1,o2)->o1.getId()-o2.getId());
        for (SortBean sortBean : list) {
            System.out.println(sortBean);
        }*/

        /*Collections.sort(list);
        for (SortBean sortBean : list) {
            System.out.println(sortBean);
        }*/
    }

    public void method04(){

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(31);
        list.add(140);
        list.add(50);
        list.add(330);
        list.add(51);
        list.add(8);
        Collections.sort(list);
        System.out.println(list);

    }

    public void method03(){

        String [] str = {"as","aw","we","eq"};
        System.out.println(Arrays.toString(str));
        List<String> list1 = Arrays.asList(str);
        System.out.println(list1);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            if(it.next().equals(10)){
                it.remove();
            }
        }
        System.out.println(list);

        /*boolean add = list.add(60);
        System.out.println(add);
        System.out.println(list.set(1,22));
        System.out.println(list);
        System.out.println(list.get(0));
        Integer [] i = new Integer[0];
        Integer[] integers = list.toArray(i);
        System.out.println(Arrays.toString(integers));*/

    }

    // 集合的遍历
    public void method02(){

        Collection<Integer> collection = new ArrayList<>();
        boolean add = collection.add(10);
        collection.add(20);
        collection.add(30);
        Iterator<Integer> it = collection.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for (Integer integer : collection) {
            System.out.println(integer);
        }


    }

    public void method01(){

        Collection<Integer> collection = new ArrayList<>();
        boolean add = collection.add(10);
        collection.add(20);
        collection.add(30);
        System.out.println(collection);
        boolean contains = collection.contains(20);
        System.out.println(contains);
        System.out.println(collection.size());
    }
}
