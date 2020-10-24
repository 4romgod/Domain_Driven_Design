package com.ddd.factory;

import com.ddd.entity.Boxer;
import org.junit.Assert;
import org.junit.Test;

public class BoxerFactoryTest {

    @Test
    public void testBoxerFactory(){
        Boxer Vasyl = BoxerFactory.createBoxer("Vasyl Lomachenko", 14, 1);
        Assert.assertNotNull(Vasyl.getId());
        System.out.println(Vasyl.toString());
    }

}