package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-23-10:34
 */
public class RegexDateUtil {

    // 年的正则表达式，范围 1000~2999
    private static String yearRegex = "[12][0-9]{3}";
    // 平年28天
    private static String monthPing = "(02-(0[1-9]||1[0-9]||2[0-8]))||((0[13578]||10||12)-(0[1-9]||1[0-9]||2[0-9]||3[01]))||((0[469]||11)-(0[1-9]||1[0-9]||2[0-9]||30))";
    // 闰年29天
    private static String monthRun = "(02-(0[1-9]||1[0-9]||2[0-9]))||((0[13578]||10||12)-(0[1-9]||1[0-9]||2[0-9]||3[01]))||((0[469]||11)-(0[1-9]||1[0-9]||2[0-9]||30))";

    /**
     * @param specificDate 字符串形式的时间，如 2020-01-31 或 2020-11-01
     * @return 返回值boolean类型，如果匹配成功返回true，如果匹配失败false
     */
    public static Boolean regexAll(String specificDate){

        if(specificDate != null && !specificDate.isEmpty()){
            // 初步校验时间格式是否正确：xxxx-xx-xx
            String regex = "[12][0-9]{3}-[0-9]{2}-[0-9]{2}";
            if(specificDate.matches(regex)){
                int oneIndex = specificDate.indexOf("-");
                String year = specificDate.substring(0,oneIndex);
                String monthDate = specificDate.substring(oneIndex + 1);
                return regexYearAndDate(year,monthDate);
            }
        }
        return false;
    }

    /**
     * @param year 年
     * @param monthAndDate 月以及对应的日
     * @return  返回值boolean类型，如果匹配成功返回true，如果匹配失败false
     */
    private static Boolean regexYearAndDate(String year,String monthAndDate){
        
        if(year.matches(RegexDateUtil.yearRegex)){
            int yearInt = Integer.parseInt(year);
            if((yearInt%4 == 0 && yearInt%100 != 0 ) || yearInt%400 == 0){
                return monthAndDate.matches(RegexDateUtil.monthRun);
            }else{
                return monthAndDate.matches(RegexDateUtil.monthPing);
            }
        }
        return false;
    }

}
