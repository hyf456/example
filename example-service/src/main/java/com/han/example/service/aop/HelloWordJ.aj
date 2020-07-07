package com.han.example.service.aop;

public aspect HelloWordJ {
	void around():call(void Hello.sayHello()){
		System.out.println("开始事务...");
		proceed();
		System.out.println("事务结束...");
	}
}
