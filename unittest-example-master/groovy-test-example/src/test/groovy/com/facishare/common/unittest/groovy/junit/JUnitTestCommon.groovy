package com.facishare.common.unittest.groovy.junit

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by wujp@fxiaoke.com on 8/24/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
abstract class JUnitTestCommon{

    @BeforeClass
    static void beforeClass() {

    }


    @AfterClass
    static void afterClass() {
    }


}
