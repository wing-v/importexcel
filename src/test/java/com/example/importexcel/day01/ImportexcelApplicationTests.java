package com.example.importexcel.day01;

import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.currentThread;

@SpringBootTest
class ImportexcelApplicationTests {

    public static void main(String[] args) throws NoSuchMethodException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,2000, TimeUnit.SECONDS, new LinkedBlockingDeque<>(300));

        AtomicInteger atomicInteger = new AtomicInteger();

    }

    static class  sychronizedtest{
        public void aaa(){
            synchronized (this){
                System.out.println("进入锁了: " + this);
                ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
                ReentrantLock lock = new ReentrantLock();

            }
            System.out.println("=================");
        }
    }

}
