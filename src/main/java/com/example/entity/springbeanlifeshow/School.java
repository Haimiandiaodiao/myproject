package com.example.entity.springbeanlifeshow;

import com.example.springframe.applicationautobindconfig.MyInfo;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 展示SpringBean的生命周期的方法
 * @Author:Dyy
 * @Description:
 * @Date: Created in 14:04 2019/1/29
 */
@Data
public class School implements BeanFactoryAware,BeanNameAware,InitializingBean, DisposableBean {
    private String name;
    private String address;
    private Integer level;
    private MyInfo myInfo;


    private BeanFactory beanFactory;
    private String beanName;
    public School() {
        System.out.println("--->【构造器】调用了School类的无参数构造方法");
    }

    public School(String name, String address, Integer level) {
        this.name = name;
        this.address = address;
        this.level = level;
        System.out.println("--->【构造器】调用了School类的全参数构造方法");
    }

    /**
     * 实现了BeanFactoryAware的方法 让Bean意识到bean工厂
     * @Author:Dyy
     * @Description:
     * @Date: Created in 14:24 2019/1/29
     * @param beanFactory
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("--->调用了【BeanFactoryAware】接口的setBeanFactory方法");
        System.out.println("--->BeanFactory--->"+beanFactory);
        this.beanFactory=beanFactory;
    }

    /**
     * 实现了BeanNameAware的方法 让Bean意识到自己的BeanName
     * @Author:Dyy
     * @Description:
     * @Date: Created in 14:31 2019/1/29
     * @param var1
     */
    @Override
    public void setBeanName(String var1){
        System.out.println("--->调用了【BeanNameAware】接口的setBeanName的方法");
        System.out.println("--->BeanName--->"+var1);
        this.beanName = var1;
    }

    /**设置完bean的属性之后调用的方法
     * @Author:Dyy
     * @Description:
     * @Date: Created in 14:37 2019/1/29
     * @param
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--->调用了【InitializingBean】接口的afterPropertiest的方法");
    }

    /**Bean销毁完之后执行的方法
     * @Author:Dyy
     * @Description:
     * @Date: Created in 14:39 2019/1/29
     * @param
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("--->调用了【DisposableBean】接口的destroy的方法");
    }


    public void myInitMethod(){
        System.out.println("--->调用了【School】的初始化方法");
    }

    public void myDestoryMethod(){
        System.out.println("--->调用了【School】的销毁方法");
    }
    //================================================================

    public void setName(String name) {
        this.name = name;
        System.out.println("--->【属性注入School】name属性");
    }

    public void setAddress(String address) {
        this.address = address;
        System.out.println("--->【属性注入School】address属性");
    }

    public void setLevel(Integer level) {
        this.level = level;
        System.out.println("--->【属性注入School】level属性");
    }

    public void setMyInfo(MyInfo myInfo) {
        this.myInfo = myInfo;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
