package _004_xmluser;

import com.example.entity.User;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.time.format.SignStyle;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 14:54 2019/3/5
 */
public class _001_BaseUse {


    @Test
    public void  base(){
        User user = new User();
        user.setPassword("1234566");
        user.setRealName("Dyy");
        user.setSalary(1);
        user.setUserName("niuniu");

        XStream xStream = new XStream();

//        xStream.alias("User", User.class);


        String s = xStream.toXML(user);

        System.out.println(s);
    }



}
