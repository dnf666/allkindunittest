package example.powermock.demo.staticvariable;


import example.pojo.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;

import java.lang.reflect.Field;

//http://stackoverflow.com/questions/5385161/powermock-testing-set-static-field-of-class

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticDemo.class)
public class StaticDemoTest {

    @Before
    public void setUp () {

    }

    @Test
    public void test() throws Exception{
        StaticDemo staticDemo = new StaticDemo();
        String id = "002mock";
        Whitebox.setInternalState(StaticDemo.class, "id",id);
        Assert.assertEquals(StaticDemo.getId(),id);

        int stuId = 2;
        Student student = new Student(stuId);
        Whitebox.setInternalState(StaticDemo.class, "student",student);
        Assert.assertEquals(StaticDemo.getStudentId(),2);

        Field field = PowerMockito.field(StaticDemo.class, "student");
        field.set(StaticDemo.class, Mockito.mock(Student.class));
        Assert.assertEquals(StaticDemo.getStudentId(),0);

        System.out.print("");
    }
}
