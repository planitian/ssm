package com.plani;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SpringTest {
    @Test
    public void testSpring(){
        //获取运用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTest two = (SpringTest) applicationContext.getBean("springTest");
        two.say();

    }

    public void say(){
        System.out.println("ssm 你好");
    }
}
