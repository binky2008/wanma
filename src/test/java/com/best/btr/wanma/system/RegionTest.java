package com.best.btr.wanma.system;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.best.btr.wanma.system.action.SystemAction;
import com.jinhe.tss.demo.TxTestSupport;

/**
 * @author Created by Lu on 15/8/31.
 */
public class RegionTest extends TxTestSupport {

    @Autowired
    SystemAction action;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testGetByParentId() {
        Long parentId = 440307L; //深圳 龙岗区
        List<?> list = action.getRegionsByZone(parentId);
        Assert.assertNotNull(list);
        Assert.assertEquals(14 ,list.size());
    }
}
