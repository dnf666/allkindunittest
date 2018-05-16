package com.facishare.common.unittest.groovy.spock

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by wujp@fxiaoke.com on 8/24/16.
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
abstract class SpockTestCommon extends Specification{

    def setup() {
        println "setup";
    }


}
