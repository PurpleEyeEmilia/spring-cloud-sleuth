package com.yryz.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2017 2017/12/21 11:30
 * @Author: pn
 */
@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    private Tracer tracer;

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.addTag("author","pn");
        LOGGER.info(tracer.getCurrentSpan().traceIdString());
        System.out.println("++++++++++++++++++" + tracer.getCurrentSpan().traceIdString() + "++++++++++++++++++");
        return null;
    }
}
