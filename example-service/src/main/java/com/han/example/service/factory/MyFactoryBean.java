package com.han.example.service.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 自己实现一个FactoryBean 生产出来的对象的前后都输出一个日志
 * <p>
 * InitializingBean：初始化完成后执行操作
 * DisposableBean：销毁后做出对应操作
 *
 * @author hanyf
 * @description //
 * @date 2020/07/07 15:19
 */
public class MyFactoryBean implements FactoryBean<Object> {

    private static final Logger logger = LoggerFactory.getLogger(MyFactoryBean.class);
    private Class<?> interfaceClazz; //实现的接口的全类名
    private Object target; //该接口的实现类
    private Object proxyObj;

    public MyFactoryBean(Class<?> interfaceClazz, Object target) {
        this.interfaceClazz = interfaceClazz;
        this.target = target;
        this.proxyObj = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{interfaceClazz}, //默认必须实现这个接口
                (proxy, method, args) -> {
                    logger.debug("invoke method......" + method.getName());
                    logger.debug("invoke method before......" + System.currentTimeMillis());
                    Object result = method.invoke(target, args);
                    logger.debug("invoke method after......" + System.currentTimeMillis());

                    return result;
                });
    }

    @Override
    public Object getObject() {
        return proxyObj; //返回这个代理对象 而不是new直接new出来的对象
    }

    @Override
    public Class<?> getObjectType() {
        return proxyObj == null ? Object.class : proxyObj.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    public static void main(String[] args) {
        MyFactoryBean factoryBean = new MyFactoryBean(UserService.class, new UserServiceImpl());

        UserService userService = (UserService) factoryBean.getObject();
        System.out.println(userService.sayHello());
    }

    private interface UserService {
        String sayHello();
    }

    private static class UserServiceImpl implements MyFactoryBean.UserService {

        @Override
        public String sayHello() {
            return "hello world";
        }
    }

}
