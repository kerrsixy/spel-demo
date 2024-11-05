package com.zjp.speldemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Loggable
 * Package: com.zjp.speldemo.annotation
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 9:17
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {
}
