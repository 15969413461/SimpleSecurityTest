
package com.zy.SimpleDemo.aopTest;

import com.zy.security.annotation.aop.After;
import com.zy.security.annotation.aop.Before;
import com.zy.security.annotation.aop.SimpleAspect;

/**
* @author zy
* @Date 2019-12-04 周三 下午 16:09:08
* @Description
* @version 
*/
@SimpleAspect
public class MyAspect {
	@After
	public void test(int id) {
		System.out.println("==After=="+id);
	}
	@Before("com.zy.SimpleDemo.aopTest.MyPoint$test()")
	public void method(int id) {
		System.out.println("==Before=="+id);
	}
}
