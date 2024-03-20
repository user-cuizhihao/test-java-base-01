package com.cui.cn.api;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-20-19:46
 */
public class DateTest {

    public static void main(String[] args) {

        DateTest dt = new DateTest();
        dt.method04();

//        dt.dateMethod01();
    }

    public void method04(){

        LocalDateTime l = LocalDateTime.now();
        LocalDateTime localDateTime = l.plusDays(11);
        DayOfWeek dayOfWeek = l.getDayOfWeek();
        System.out.println(dayOfWeek);
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = d.format(localDateTime);
        System.out.println(format);

    }

    private void method03(){

        //LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.now();
//        LocalDateTime localDateTime = ldt.withDayOfMonth(33);
        //LocalDateTime localDateTime = ldt.withMonth(10);
        System.out.println(ldt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(ldt);
        System.out.println(format);

        /*Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.YEAR);
        System.out.println(i);*/

    }

    private void method02(){

        Date d = new Date(1710966709354l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d);
        System.out.println(format);

    }

    public void dateMethod01(){

        Date date = new Date();
        long time = date.getTime(); // 1710966709354
        System.out.println(time);
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

    }

}
