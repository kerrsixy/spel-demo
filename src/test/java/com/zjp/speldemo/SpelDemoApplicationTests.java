package com.zjp.speldemo;

import com.zjp.speldemo.controller.DemoController;
import com.zjp.speldemo.entity.Address;
import com.zjp.speldemo.entity.Customer;
import com.zjp.speldemo.entity.Person;
import com.zjp.speldemo.entity.User;
import com.zjp.speldemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@SpringBootTest
class SpelDemoApplicationTests {

    public static void main(String[] args) {
        // 1.字面量
        ExpressionParser parser = new SpelExpressionParser();
        String result = parser.parseExpression("'Hello, World!'").getValue(String.class);
        log.info("{}", (result)); // 输出: Hello, World!
        // 2.变量引用
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("osName", System.getProperty("os.name"));
        String osName = parser.parseExpression("'OS Name: ' + #osName").getValue(context, String.class);
        log.info("{}", (osName)); // 输出: OS Name: Windows 11
        // 3.属性访问
        Customer customer = new Customer("John Doe", 30);
        context.setRootObject(customer);
        String name = parser.parseExpression("name").getValue(context, String.class);
        log.info("{}", (name)); // 输出: John Doe
        // 4.方法调用
        String upperCaseName = parser.parseExpression("name.toUpperCase()").getValue(context, String.class);
        log.info("{}", (upperCaseName)); // 输出: JOHN DOE
        // 5.算术运算
        int agePlusTen = parser.parseExpression("age + 10").getValue(context, Integer.class);
        log.info("{}", (agePlusTen)); // 输出: 40
        // 6.逻辑运算
        boolean isAdult = parser.parseExpression("age >= 18").getValue(context, Boolean.class);
        log.info("{}", (isAdult)); // 输出: true
        // 7.三元运算
        String ageGroup = parser.parseExpression("age >= 18 ? 'Adult' : 'Minor'").getValue(context, String.class);
        log.info("{}", (ageGroup)); // 输出: Adult
        // 8.集合操作
        Map<String, Map<String, String>> nestedMap = parser.parseExpression("{'person':{'name':'John','age':'30'}}").getValue(context, Map.class);
        log.info("{}", (nestedMap)); // 输出: {person={name=John, age=30}}
        // 9.正则表达式匹配
        boolean matches = parser.parseExpression("'Hello'.matches('H.*')").getValue(Boolean.class);
        log.info("{}", (matches)); // 输出: true
        // 10.类型转换
        int age = parser.parseExpression("'30'").getValue(Integer.class);
        log.info("{}", (age)); // 输出: 30
        // 11.对象图导航
        Address address = new Address("New York");
        customer.setAddress(address);
        context.setRootObject(customer);
        String city = parser.parseExpression("address.city").getValue(context, String.class);
        log.info("{}", (city)); // 输出: New York
        // 12.环境变量访问
        context.setVariable("systemProperties", System.getProperties());
        String javaHome = parser.parseExpression("#systemProperties['java.home']").getValue(context, String.class);
        log.info("{}", (javaHome));
    }

    @Autowired
    private Person person;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DemoController demoController;
    @Autowired
    private DemoService demoService;

    @Test
    public void testApplicationScenario() {
        // 1.配置文件中
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) context.getBean("customer");
        log.info("{}", customer); // 输出: Customer{name='John Doe', age=30, address=null}
        // 2.注解中
        log.info("{}", person); // 输出: Person{name='John Doe', age=30}
        // 3.方法参数中
        String greet = restTemplate.getForObject("http://localhost:8080/greet", String.class);
        log.info("{}", greet); // 输出: Hello, 1730769227753
        // 4.AOP 切面中
        User user = demoService.getUser("zhangsan");
        log.info("{}", user); // Entering method with name: zhangsan    User{id='1', name='zhangsan', age=18}
        // 5.与其他Spring组件
        User user1 = demoController.getById("1");
        log.info("{}", user1);
    }
}
