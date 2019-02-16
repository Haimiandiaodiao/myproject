package SpringPackageUse;

import com.example.springframe.applicationautobindconfig.MyInfo;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 11:44 2019/1/28
 */
public class BeanWrapperUse {

    @Test
    public void 快速访问Bean属性(){
        MyInfo myInfo = new MyInfo();
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(myInfo);
        beanWrapper.setPropertyValue("name","Dyy");
        beanWrapper.setPropertyValue("age",11);
        System.out.println(myInfo);
    }

    @Test
    public void name() {
        short a = 1;
        short b = 1;
        byte c = 1+1;
        System.out.println("a相加之前得多少"+a);
        System.out.println("a相加之后得多少"+a);
    }
}
