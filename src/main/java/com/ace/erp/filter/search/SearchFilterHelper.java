/**
 * Copyright (c) 20095-2013 https://github.com/zhangkaitao
 *
 *
 */


package com.ace.erp.filter.search;

import com.ace.erp.exception.SearchException;
import com.ace.erp.utils.SearchOperator;

/**
 * Project_Name: smart-erp
 * File: SearchFilterHelper
 * User: denghp
 * Date: 10/16/13
 * Time: 3:05 PM
 */
public final class SearchFilterHelper {
    /**
     * 根据查询key和值生成Condition
     *
     * @param key   如 name_like
     * @param value
     * @return
     */
    public static SearchFilter newCondition(final String key, final Object value) throws SearchException {
        return Condition.newCondition(key, value);
    }

    /**
     * 根据查询属性、操作符和值生成Condition
     *
     * @param searchProperty
     * @param operator
     * @param value
     * @return
     */
    public static SearchFilter newCondition(final String searchProperty, final SearchOperator operator, final Object value) {
        return Condition.newCondition(searchProperty, operator, value);
    }


    /**
     * 拼or条件
     *
     * @param first
     * @param others
     * @return
     */
//    public static SearchFilter or(SearchFilter first, SearchFilter... others) {
//        OrCondition orCondition = new OrCondition();
//        orCondition.getOrFilters().add(first);
//        if (ArrayUtils.isNotEmpty(others)) {
//            orCondition.getOrFilters().addAll(Arrays.asList(others));
//        }
//        return orCondition;
//    }


    /**
     * 拼and条件
     *
     * @param first
     * @param others
     * @return
     */
//    public static SearchFilter and(SearchFilter first, SearchFilter... others) {
//        AndCondition andCondition = new AndCondition();
//        andCondition.getAndFilters().add(first);
//        if (ArrayUtils.isNotEmpty(others)) {
//            andCondition.getAndFilters().addAll(Arrays.asList(others));
//        }
//        return andCondition;
//    }

}
