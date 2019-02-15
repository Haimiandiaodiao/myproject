package com.example.server.book;

/**
 * 使用此类来完成代理的实现
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:08 2019/1/31
 */
public class BookServiceImpl implements BookService {

    @Override
    public void openBook() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("花费了1s钟打开书");
    }

    @Override
    public void readBook() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("花费了5s钟读完了书");
    }

    @Override
    public void closeBook() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("花费了2s钟读合上了书");
    }
}
