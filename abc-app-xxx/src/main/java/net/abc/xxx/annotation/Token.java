package net.abc.xxx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {

	/**
	 * 
	 * @return
	 */
	boolean save() default false;

	/**
	 * 
	 * @return
	 */
	boolean remove() default false;

}