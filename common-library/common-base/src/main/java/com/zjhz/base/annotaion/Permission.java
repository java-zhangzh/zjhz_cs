package com.zjhz.base.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE}) 
@Retention(RetentionPolicy.RUNTIME)
/**
 * 权限
 */
public @interface Permission{
	public String value() default "";
}
