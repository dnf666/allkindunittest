package example.mock.init.demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
/**
 * Created by Administrator on 15-7-16.
 */
public class TestInitMock {
    @Test
    public void test() {
        List inst = Mockito.mock(List.class);
    }
}
