package SpringPackageUse._002_代理的测试;

import com.example.server.book.BookInvacationHandler;
import com.example.server.book.BookService;
import com.example.server.book.BookServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:10 2019/1/31
 */
public class _001_JDK动态代理的实现 {

    @Test
    public void JDK动态代理的实现() throws InterruptedException {
        BookServiceImpl bookService = new BookServiceImpl();
        BookInvacationHandler bookInvacationHandler = new BookInvacationHandler(bookService);
        BookService proxy = (BookService)Proxy.newProxyInstance(bookService.getClass().getClassLoader(), bookService.getClass().getInterfaces(), bookInvacationHandler);

        Method[] methods = proxy.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


        proxy.openBook();
        proxy.readBook();
        proxy.closeBook();
    }
}
