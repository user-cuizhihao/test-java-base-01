package com.cui.cn.enumAndMathT;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-11-18:17
 */
public class FanT<T> {

    T t;

    public FanT(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void show(){
        System.out.println(t.getClass());
    }
}

 class TestT{

     public static void main(String[] args) {
         FanT<String> ft = new FanT<>("123");
         ft.show();
         ft.setT("321");
         ft.show();
         System.out.println(ft.getT());
     }

}