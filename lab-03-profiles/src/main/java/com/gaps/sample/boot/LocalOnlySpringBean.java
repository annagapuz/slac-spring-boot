package com.gaps.sample.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LocalOnlySpringBean {

    private static final Logger LOG = LoggerFactory.getLogger(LocalOnlySpringBean.class);

    public LocalOnlySpringBean() {
        LOG.info("I only run in the LOCAL profile");
    }
}
