package com.example.demo.ComponentTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class CommonMethod {

//    protected Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    protected DimTerrifyService dimTerrifyService;
//
//    private static CommonMethod serverHandler;
//
//    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
//    public void init() {
//        serverHandler = this;
//        serverHandler.dimTerrifyService = this.dimTerrifyService;
//        // 初使化时将已静态化的testService实例化
//    }
//
//    public List getTerrify() {
//        logger.info("测试common的注入");
//        System.out.println(serverHandler.dimTerrifyService == null);
//        List<DimTerrifyEntity> allTerrify = serverHandler.dimTerrifyService.findAllTerrify();
//        System.out.println(" dim -- =  " + serverHandler.dimTerrifyService);
//        System.out.println(allTerrify);
//        return allTerrify;
//    }
}