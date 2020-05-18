package com.example.importexcel.day510;

import java.util.concurrent.*;

public class ThreadTest {
    private static final int default_size = 10;

    private static final long default_keepAlive_time = 60L;

    private static final int default_queue = 500;

    public static void main(String[] args) throws Exception {
        new Thread();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(default_size, default_size * 4, default_keepAlive_time, TimeUnit.SECONDS, new ArrayBlockingQueue<>(default_queue));

        Executors.newCachedThreadPool();

        try {
            Future<Boolean> future = executor.submit(new Callable<Boolean>() {

                @Override
                public Boolean call() throws Exception {
                    return null;
                }
            });


            Boolean aBoolean = future.get();

            if (aBoolean == false) {
                throw new Exception("");
            }
        } catch (InterruptedException e) {
            throw  new Exception(e.getMessage());
        } catch (ExecutionException e) {
            throw  new Exception(e.getMessage());
        }


    }
}
