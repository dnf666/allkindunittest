package example.spring.test.demo;

import example.pojo.Student;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.doReturn;

/**
 * Created by wangxun on 2016/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SuppressWarnings("SpringJavaAutowiringInspection")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {
    @Autowired
    private Student student;

    @org.junit.Test
    public void test(){
//        System.out.println(student.getI());
        doReturn(100).when(student).getI();
        System.out.println(student.getI());
    }
}
