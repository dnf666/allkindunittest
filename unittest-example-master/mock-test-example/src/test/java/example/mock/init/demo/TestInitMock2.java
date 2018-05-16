package example.mock.init.demo;

import example.pojo.Student;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

import org.mockito.MockitoAnnotations;

/**
 * Created by Administrator on 15-7-16.
 */

public class TestInitMock2 {
    @org.mockito.Mock
    private Student student;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);//使用前
    }
    @Test
    public void test(){

    }

}
