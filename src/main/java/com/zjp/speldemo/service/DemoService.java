package com.zjp.speldemo.service;

import com.zjp.speldemo.annotation.Loggable;
import com.zjp.speldemo.entity.User;
import org.springframework.stereotype.Service;

/**
 * ClassName: DemoService
 * Package: com.zjp.speldemo.service
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 9:22
 */
@Service
public class DemoService {
    @Loggable
    public User getUser(String name) {
        return new User("1", "zhangsan", 18);
    }
}
