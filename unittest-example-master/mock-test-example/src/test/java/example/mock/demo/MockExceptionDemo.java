package example.mock.demo;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 15-7-16.
 */
public class MockExceptionDemo {

    @Test(expected = RuntimeException.class)
    public void doMock() {
        List mockedList = mock(List.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        mockedList.clear();
    }
}
