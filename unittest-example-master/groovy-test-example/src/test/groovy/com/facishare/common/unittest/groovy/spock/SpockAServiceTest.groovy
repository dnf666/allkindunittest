package com.facishare.common.unittest.groovy.spock

import com.facishare.common.unittest.service.AService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by wujp@fxiaoke.com on 8/24/16.
 */
class SpockAServiceTest extends SpockTestCommon {

    @Autowired
    private AService service;

    def test() {
        when:
        println "remove me"
        def result = service.run();
        then:
        result == true;
    }
}
