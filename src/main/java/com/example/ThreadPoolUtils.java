package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:53 2019/1/27
 */
public class ThreadPoolUtils {

    private static final ExecutorService dataCleanPool;

    static {
        dataCleanPool = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    /**
     * 直接调用这个方法提交任务
     * @Description:
     * @Date: Created in 18:02 2019/1/27
     * @param task
     */
    public static void submitTask(Runnable task){
        dataCleanPool.submit(task);
    }
}
