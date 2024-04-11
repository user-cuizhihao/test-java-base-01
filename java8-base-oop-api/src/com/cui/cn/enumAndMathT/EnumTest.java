package com.cui.cn.enumAndMathT;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-1:01
 */
public enum EnumTest {

    ONE("one_1","one_2"),TOW("tow_1","tow_2");

    private String str01;
    private String str02;

    private EnumTest(String str01,String str02){

        this.str01 = str01;
        this.str02 = str02;
    }

    public String getStr01() {
        return str01;
    }

    public String getStr02() {
        return str02;
    }

    @Override
    public String toString() {
        return "EnumTest{" +
                "str01='" + str01 + '\'' +
                ", str02='" + str02 + '\'' +
                '}';
    }
}
