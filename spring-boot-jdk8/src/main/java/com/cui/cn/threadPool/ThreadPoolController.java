package com.cui.cn.threadPool;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-07-2:00
 */
@RestController
@RequestMapping("/ThreadPoolController")
public class ThreadPoolController {


    @RequestMapping(path = "/testMethod",method = RequestMethod.GET)
    public String testMethod(){

        return "123,你好！";
    }

}
