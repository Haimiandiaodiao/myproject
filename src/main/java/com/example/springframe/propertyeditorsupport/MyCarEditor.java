package com.example.springframe.propertyeditorsupport;

import com.example.entity.springbeanlifeshow.Car;

import java.beans.PropertyEditorSupport;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 17:51 2019/1/30
 */
public class MyCarEditor extends PropertyEditorSupport {

    /**
     * 将字面值转化为属性类型对象
     * @Author:Dyy
     * @Description:
     * @Date: Created in 17:55 2019/1/30
     * @param text
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text == null || text.indexOf(",") == -1){
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        Car car = new Car();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));

        setValue(car);
    }


}
