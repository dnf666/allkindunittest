package com.facishare.common.unittest.groovy.junit

import com.facishare.common.unittest.service.AService
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by wujp@fxiaoke.com on 8/24/16.
 */
class JUnitAServiceTest extends JUnitTestCommon {

    @Autowired
    private AService service;

    @Test
    void test() {
        println "remove me"
        assert service.run();
    }

    @BeforeClass
    static void beforeClass() {

    }


    @AfterClass
    static void afterClass() {
    }


}
