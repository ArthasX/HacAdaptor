package com.openmind.hacadaptor.mvc;

import com.alibaba.fastjson.JSON;
import com.openmind.hacadaptor.dao.DeviceMapper;
import com.openmind.hacadaptor.mode.Device;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuBin on 2017/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
public class TestDAO extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    DeviceMapper deviceMapper;

    @Test
    public void testSelect() {
        Device d = new Device("1234");
        d = deviceMapper.select(d);
        System.out.println(JSON.toJSONString(d));
        Assert.assertEquals("test device id ", "aaaa", d.getDeviceName());
    }

    @Test
    public void testInsert() {
        Device d = new Device("abcdefg");
        int c = deviceMapper.insert(d);
        Assert.assertEquals(1, c);
    }

    @Test
    public void testFuzzySelect() {
        Device d1 = new Device();
        d1.setDeviceName("b");
        List<Device> list = deviceMapper.fuzzySelect(d1);
        System.out.println(JSON.toJSONString(list));
//        Assert.assertEquals("test device id ","aaaa",d.getName());
    }

    @Test
    public void testDelete(){
        Device d = new Device("abcdefg");
        int c = deviceMapper.delete(d);
        Assert.assertEquals(1, c);
    }

    @Test
    public void testUpdate(){
        Device d = new Device("abcdefg");
        int c = deviceMapper.update(d);
        Assert.assertEquals(1, c);
    }


    @Test
    public void testInsertBatch(){
        List<Device>list=new ArrayList<>();
        Device d1 = new Device("dddd1");
        Device d2 = new Device("dddd2");
        Device d3 = new Device("dddd3");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        int i=deviceMapper.insertBatch(list);
        System.out.println("insert count:"+i);
        Assert.assertEquals(i,3);
    }
}
