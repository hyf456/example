package com.han.example.service.aop;

/**
 * @Description Hello类
 * @Date 2020/7/6 11:04
 * @Author hanyf
 */
public class HelloWord {

    public void sayHello(){
        System.out.println("hello world !");
    }
    public static void main(String args[]){
        HelloWord helloWord =new HelloWord();
        helloWord.sayHello();
    }
}
