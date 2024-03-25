package com.cui.cn.api;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-25-6:13
 */
public class HashMaptest {

    public static void main(String[] args) {

        HashMaptest hht = new HashMaptest();
        hht.method03();

//        hht.method01();
    }

    public void method03(){

//        Map<String,String> map = new ConcurrentHashMap<>();
        Hashtable<String,String> map = new Hashtable<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        System.out.println(map);

    }

    // 遍历
    public void method02(){

        Map<String,Double> map = new HashMap<>();
        map.put("s",88.9);
        map.put("d",85.9);
        map.put("w",68.9);
        map.put("c",98.9);
        /*Collection<Double> values = map.values();
        for (Double value : values) {
            System.out.println(value);
        }*/

        /*Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next + " = " + map.get(next));
        }*/

        // 获得key value
        /*Set<Map.Entry<String, Double>> entries = map.entrySet();
        Iterator<Map.Entry<String, Double>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Double> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }*/
    }

    public void method01(){

        Map<String,String> map = new HashMap<>();
        String a1 = map.put("1", "a");
        String a = map.put("1", "b");
        /*System.out.println(a1);
        System.out.println(a);
        System.out.println(map);*/
        /*String s = map.get("1");
        System.out.println(s);*/
        System.out.println(map.containsKey("2"));
        System.out.println(map.containsValue("b"));
    }
}
