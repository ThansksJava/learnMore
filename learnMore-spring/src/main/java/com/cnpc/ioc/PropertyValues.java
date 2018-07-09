package com.cnpc.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/9
 * @Time 19:44
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }
    public void  addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
