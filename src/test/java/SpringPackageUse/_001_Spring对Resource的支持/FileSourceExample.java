package SpringPackageUse._001_Spring对Resource的支持;

import com.example.SpringBootTestApplicaiton;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.*;

/**
 * 使用spring的Source来获得资源
 * @Author:Dyy
 * @Description:
 * @Date: Created in 19:22 2019/1/28
 */
public class FileSourceExample {

    /**
     *
     * @Author:Dyy
     * @Description:
     * @Date: Created in 19:22 2019/1/28
     * @param
     */

    @Test
    public void getFile(){
        //1.使用系统文件方式来加载文件
        String s = "F:\\Project\\myproject\\src\\main\\resources\\application.yml";
        //本地系统的路径
        FileSystemResource pathResource = new FileSystemResource(s);

        System.out.println(pathResource.getFilename());

        //2.使用类路径方式加载文件resourcesz在执行时候复制到类路径下
        ClassPathResource classPathResource = new ClassPathResource("application.yml");
        ClassPathResource banner = new ClassPathResource("banner.jpg");

        System.out.println(classPathResource.getFilename());
        System.out.println(banner.getFilename());

        //3.使用WritableResource接口写资源文件

    }

    @Test
    public void usePathMatchingResourcePatternResovler() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:org/springframework/core/io/support/PathMatchingResourcePatternResolver.class");
        for (Resource resource : resources) {
            InputStream inputStream = resource.getInputStream();
        }

        Resource resource = resolver.getResource("classpath:org/springframework/core/io/support/PathMatchingResourcePatternResolver.class");
        System.out.println(resource.exists());


        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    }

    @Test
    public void userApplicationContext(){
        AnnotationConfigApplicationContext  application = new AnnotationConfigApplicationContext(SpringBootTestApplicaiton.class);
        application.refresh();
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
