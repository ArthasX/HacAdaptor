package com.openmind.hacadaptor.mvc;

import com.openmind.hacadaptor.dao.DeviceMapper;
import com.openmind.hacadaptor.mode.Device;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
public class TestDAO {
    @Autowired
    DeviceMapper deviceMapper;

    @Test
    public void testSelect() {
        Device d = new Device("1234");
        d = deviceMapper.select(d);
        System.out.println(d.getName());
        Assert.assertEquals("test device id ","aaaa",d.getName());
    }
}
