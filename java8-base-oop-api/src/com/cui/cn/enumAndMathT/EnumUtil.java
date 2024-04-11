package com.cui.cn.enumAndMathT;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-1:43
 */
public enum EnumUtil {

    A(1,"a"),
    B(1,"b"),
    C(1,"c");

    private Integer i;
    private String j;

    private EnumUtil(Integer i,String j){
        this.i = i;
        this.j = j;
    }

    public Integer i(){
        return i;
    }

    public String j(){
        return j;
    }

    /**
     * 通过i获得j
     */
    public String getJByI(Integer i){

        EnumUtil[] values = EnumUtil.values();
        for (EnumUtil value : values) {
            if(value.i == i){
                return value.j;
            }
        }
        return null;
    }
}