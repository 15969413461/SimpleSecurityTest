
package com.zy.SimpleDemo.aopTest;

import com.zy.security.annotation.aop.SimplePointcut;

/**
* @author zy
* @Date 2019-12-04 周三 下午 16:08:55
* @Description
* @version 
*/
public class MyPoint {
	@SimplePointcut("com.zy.SimpleDemo.aopTest.MyPoint$test()")
	public void test(int id) {
		System.out.println("==test()=="+id);
	}
	@SimplePointcut("com.zy.SimpleDemo.aopTest.MyPoint$test2()")
	public void test2() {}
}
