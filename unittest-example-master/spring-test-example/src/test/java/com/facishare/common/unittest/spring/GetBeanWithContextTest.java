package com.facishare.common.unittest.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class GetBeanWithContextTest extends AbstractCommonTest {

    public <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }

    public Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    protected ApplicationContext getContext() {
        return applicationContext;
    }

    @Test
    public void testApplicationContext() {
        Employee employee = (Employee) getBean("employee");
        assertEquals(20, employee.getAge().intValue());
    }

}
