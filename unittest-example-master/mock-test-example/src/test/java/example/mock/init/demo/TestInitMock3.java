package example.mock.init.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Administrator on 15-7-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestInitMock3 {//Engine会注入到Car里面
    @InjectMocks
    private Car car = new Car();
    @Mock
    private Engine engine;

    @Test
    public void test(){
        System.out.println(car.getEngine());
        System.out.println();
    }

}
