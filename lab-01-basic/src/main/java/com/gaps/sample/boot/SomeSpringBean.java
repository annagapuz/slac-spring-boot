package com.gaps.sample.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SomeSpringBean {

    private static final Logger LOG = LoggerFactory.getLogger(SomeSpringBean.class);

    public SomeSpringBean() {
        LOG.info("I'm a Spring Bean and I've been constructed");
    }
}
