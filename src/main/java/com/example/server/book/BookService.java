package com.example.server.book;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:07 2019/1/31
 */
public interface BookService {

    void openBook() throws InterruptedException;

    void readBook() throws InterruptedException;

    void closeBook() throws InterruptedException;
}
