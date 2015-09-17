package com.best.btr.wanma.bas;

import com.best.btr.wanma.bas.action.RegionAction;
import com.best.btr.wanma.bas.entity.Region;
import com.jinhe.tss.demo.TxTestSupport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Created by Lu on 15/8/31.
 */
public class RegionTest extends TxTestSupport {

    @Autowired
    RegionAction action;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testGetByParentId() {
        Long parentId = 440307L; //深圳 龙岗区
        List<Region> list = action.getRegionByParentId(parentId);
        Assert.assertNotNull(list);
        Assert.assertEquals(14 ,list.size());
    }
}
