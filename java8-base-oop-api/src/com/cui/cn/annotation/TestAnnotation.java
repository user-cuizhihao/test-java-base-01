package com.cui.cn.annotation;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-10-18:20
 */
@MyAnnotation(c = {},name = "类上面")
public class TestAnnotation {
    
    @MyAnnotation(name = "方法上",c = {StudentBean.class})
    public void method01(){
        
    }
}
