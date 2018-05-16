package example.mock.demo;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
/**
 /**
 * Created by Administrator on 15-7-16.
 */
public class StubDemo {

    @Test(expected = RuntimeException.class)
    public void doMock() throws RuntimeException {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");//stubbing
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        assertThat(mockedList.get(0).equals("first")).isEqualTo(true);
        mockedList.get(1);//抛出 runtime exception
        assertThat(mockedList.get(999) == null).isEqualTo(true);
        verify(mockedList).get(0);
        when(mockedList.get(anyInt())).thenReturn("anyint");//参数匹配
        assertThat(mockedList.get(999).equals("anyint")).isEqualTo(true);
    }

}
