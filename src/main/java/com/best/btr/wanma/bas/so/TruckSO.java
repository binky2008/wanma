package com.best.btr.wanma.bas.so;

import com.jinhe.tss.framework.persistence.pagequery.MacrocodeQueryCondition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Hsian on 15/9/11.
 */
public class TruckSO extends MacrocodeQueryCondition {
    @Override
    public Map<String, Object> getConditionMacrocodes() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("${code}", " and o.code = :code");
        map.put("${cardCode}", " and o.cardCode = :cardCode");
        map.put("${barCode}", " and o.barCode = :barCode");
        map.put("${type}", " and o.type = :type");
        map.put("${brand}", " and o.ssq = :brand");
        map.put("${updateTime}", " and o.updateTime = :updateTime");
        return map;
    }
}
