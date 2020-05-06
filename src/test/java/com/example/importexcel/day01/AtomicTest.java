package com.example.importexcel.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Count1 count = new Count1();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() ->count.increase());
        }



        // 等待上述的线程执行完
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);


        System.out.println("公众号：Java3y---------");
        System.out.println(count.getCount());
    }
}

class Count1 {
//    private Integer count = 0;
    private  AtomicInteger count = new AtomicInteger(0);

    public Integer getCount(){
        return count.get();
    }

    public void increase(){
        count.incrementAndGet();
    }
}