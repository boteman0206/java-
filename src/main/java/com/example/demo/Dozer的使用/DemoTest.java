package com.example.demo.Dozer的使用;


import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dozer")
public class DemoTest {
    /**
     * 这是一个实体类的快速赋值的语句  可以简化代码的使用
     */
    @Autowired
    protected Mapper dozerMapper;

    public static void main(String[] args) {

        DemoTest d1 = new DemoTest();
        d1.test();

    }


    @GetMapping("/test")
    public void test(){
        ArticleOP articleOP = new ArticleOP();
        articleOP.setName("jack");
        articleOP.setAge("12");
        articleOP.setTgiThread("tgi13");
        //        使用dozerMapper向另一个实体类赋值
        ArticleVo articleVo = dozerMapper.map(articleOP,ArticleVo.class);
        //        测试是可以进行赋值的
        System.out.println(articleVo.getAge().getClass());
        System.out.println(articleVo);
    }



}
