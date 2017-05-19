package com.cs.common;

import com.cs.common.service.data.CommonJpaDataAccessService;
import com.cs.common.service.data.CommonXAJpaDataAccessService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import javax.inject.Inject;

/**
 * Created by sankey on 2017-05-15.
 */
@SpringBootTest(classes = {TestApplication.class})
public class IntegrationTestBase extends AbstractTestNGSpringContextTests {
    @Inject protected CommonXAJpaDataAccessService commonXAJpaDataAccessService;
    @Inject protected CommonJpaDataAccessService commonJpaDataAccessService;
}
