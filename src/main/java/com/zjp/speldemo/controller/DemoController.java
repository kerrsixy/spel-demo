package com.zjp.speldemo.controller;

import com.zjp.speldemo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: DemoController
 * Package: com.zjp.speldemo.controller
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 9:07
 */
@RestController
public class DemoController {
    @GetMapping("/greet")
    public String greet(@Value("#{'Hello, ' + T(java.lang.System).currentTimeMillis()}") String message) {
        return message;
    }

    /**
     * Cacheable：在方法执行前spring先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；若没有数据，调用方法并将方法返回值放到缓存中
     * value：缓存的名称，每个缓存名称下面可以有多个key
     * key：缓存的key
     */
    @GetMapping
    @Cacheable(cacheNames = "userCache", key = "#id")
    public User getById(String id) {
        System.out.println("getById");
        User user = new User(id, "zhangsan", 18);
        return user;
    }
}
