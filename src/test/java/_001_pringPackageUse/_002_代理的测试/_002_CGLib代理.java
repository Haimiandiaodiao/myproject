package _001_pringPackageUse._002_代理的测试;

import com.example.server.book.BookServiceImpl;
import com.example.server.book.CglibProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * 通过CGLib对类实现代理
 * @Author:Dyy
 * @Description:
 * @Date: Created in 16:17 2019/1/31
 */
public class _002_CGLib代理 {
    
    @Test
    public void 使用CGLib来增强代码() throws InterruptedException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookServiceImpl.class);
        enhancer.setCallback(new CglibProxy());
        BookServiceImpl dd = (BookServiceImpl)enhancer.create();

        dd.openBook();
        dd.readBook();
        dd.closeBook();
    }
}
