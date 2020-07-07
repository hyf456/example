package com.han.example.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Date 2020/7/7 18:16
 * @Author hanyf
 */
public class Controller {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private RootConfig.MyFactoryBean myFactoryBean;
	@Autowired
	private RootConfig.MyObjectFactory myObjectFactory;
	@Autowired
	private Daughter daughter;
	//@Autowired //这里son不能直接注入，但是上面的daughter可以，因为它是FactoryBean，Spring在Bean初始化时会对其进行支持处理
	//private Son son;

	@ResponseBody
	@GetMapping("/hello")
	public String helloGet() throws Exception {
		// 这里注意一下：ApplicationContext是可以直接注入的，可谓非常的方便（至于原因：原理的博文里有说）
		System.out.println(applicationContext); //WebApplicationContext for namespace 'dispatcher-servlet': s ...
		System.out.println(applicationContext.getParent()); //Root WebApplicationContext: startup date [Tue Mar 05

		//========================================
		System.out.println(myFactoryBean); //com.fsx.config.RootConfig$MyFactoryBean@1f8bccbb
		// 这样子，我们是能拿到一个对象的。但需要注意：每get一次，就是new了一个新的
		System.out.println(myObjectFactory.getObject()); //com.fsx.bean.Son@309e3495
		System.out.println(daughter); //com.fsx.bean.Daughter@6cb10346

		// 需要注意的是：单独自己去get的话，出来的都是不同的对象（因此此工厂Bean，Spring又没有增强，所以铁定会执行方法体）
		System.out.println(myFactoryBean.getObject() == myFactoryBean.getObject()); //false
		System.out.println(myObjectFactory.getObject() == myObjectFactory.getObject()); //false
		return "hello...Get";
	}
}
