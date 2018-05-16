package com.facishare.common.unittest.groovy.spock

import com.facishare.common.unittest.service.AService
import com.facishare.common.unittest.service.AServiceUtil
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created with IntelliJ IDEA.
 * User: wujp@fxiaoke.com
 * Date: 16/8/25
 * Time: 上午10:55
 */
class SpockGroovyStaticMethodTest extends SpockTestCommon{

    @Autowired
    private AService service;
    def setup(){
        AServiceUtil.metaClass.static.returnTrue = { return false}
    }
    def "test rewrite static class method"() {
        when:
        def result = AServiceUtil.returnTrue()
        then:
        false==result
    }

    def "test rewrite static class method and run in spring"() {
        when:
        def result = service.run()
        then:
        true ==result  //groovy can not mock static class which is defined in java
    }

    def "test groovy mock static class method and run in spring"() {
        when:
        GroovyMock(AServiceUtil, global: true)
        AServiceUtil.returnTrue() >> false
        def result = service.run()
        then:
        true ==result  //groovy can not mock static class which is defined in java
    }

}