package example.mock.demo;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 15-7-16.
 */
public class SuccessiveCallsDemo {//连续调用

    @Test
    public void doMock() {
        List<Integer> mockList = mock(List.class);
        //模拟连续调用返回期望值，如果分开，则只有最后一个有效
        when(mockList.get(0)).thenReturn(0);
        when(mockList.get(0)).thenReturn(1);
        when(mockList.get(0)).thenReturn(2);

        when(mockList.get(1)).thenReturn(0).thenReturn(1);

        assertThat(mockList.get(0) == 2).isEqualTo(true);
        assertThat(mockList.get(0) == 2).isEqualTo(true);
        assertThat(mockList.get(1) == 0).isEqualTo(true);
        assertThat(mockList.get(1) == 1).isEqualTo(true);
        assertThat(mockList.get(1) == 1).isEqualTo(true);
        System.out.println(mockList.get(1));
    }
}
