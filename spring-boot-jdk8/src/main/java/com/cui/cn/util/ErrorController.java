package com.cui.cn.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-07-12:29
 */
@RestController
public class ErrorController {

    @RequestMapping(value = "/errorMethod",method = RequestMethod.GET)
    public String errorMethod(){
        return "出错了";
    }
}
