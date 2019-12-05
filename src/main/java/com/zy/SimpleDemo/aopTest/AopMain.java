
package com.zy.SimpleDemo.aopTest;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.zy.aop.ClassModificationHandler;
import com.zy.aop.handler.AnnotationModuleHandler;
import com.zy.aop.interfaces.ClassModificationModule;
import com.zy.reflect.AopRelectHandler;
import com.zy.reflect.analysis.repository.AopAnnoRepositoryImpl;

/**
* @author zy
* @Date 2019-12-04 周三 下午 16:13:20
* @Description aop功能测试
* @version 
*/
public class AopMain {
	public static void main(String[] args) {
		AopRelectHandler handler = new AopRelectHandler();
		// 扫描根目录下的注解 
		handler.invoke("com.zy.SimpleDemo.aopTest");
		
		AopAnnoRepositoryImpl annotationRepository = handler.getAnnotationRepository();
		Map<String, Method> pointcut = annotationRepository.getPointcut();
		
		// 将切面方法织入切点以生成切面
		AnnotationModuleHandler annotationModuleHandler = new AnnotationModuleHandler();
		Map<String, Map<Class<?>, List<Method>>> aspect = annotationModuleHandler.invoke(annotationRepository);
		
		// 根据切面信息进行字节码操作
		ClassModificationModule classModificationHandler = new ClassModificationHandler();
		// 执行一次即可，否则会发送镶套,因为实现的前置通知和后置通知是通过javassist的after...和before...方法。
		classModificationHandler.handler(aspect, pointcut);
		
		MyPoint myPoint = new MyPoint();
		myPoint.test(5);
		System.out.println("------------------");
		myPoint.test2();
	}
}
