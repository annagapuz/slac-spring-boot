package com.gaps.sample.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SomeSpringBean {

    private static final Logger LOG = LoggerFactory.getLogger(SomeSpringBean.class);

    @Value("${some.property.key}")
    private String somePropertyValue;

//    @Autowired
//    private GamingConfiguration gamingConfiguration;

    public SomeSpringBean(@Autowired GamingConfiguration gamingConfiguration) {
        LOG.info("I'm a Spring Bean and I've been constructed");
        LOG.info("Available gaming systems are {}", gamingConfiguration.getSystems());
        LOG.info("Available games in library are {}", gamingConfiguration.getLibrary().getQuantity());
    }

    @PostConstruct
    public void postBeanCreation() {
        LOG.info("The property value is: {}", somePropertyValue);
    }
}
