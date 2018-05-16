package example.mock.demo;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.NoInteractionsWanted;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 15-7-16.
 */
public class InteractionDemo {

    @Test
    public void verifyZero() {
        List list = mock(List.class);
        List list2 = mock(List.class);
        List list3 = mock(List.class);
        list.add(1);
        verify(list).add(1);
        verify(list, never()).add(2);
//        list2.clear();
        //验证零互动行为,即方法没有被调用
        verifyZeroInteractions(list2, list3);
    }

    @Test
    public void find_redundant_interaction() {
        List list = mock(List.class);
        list.add(1);
        list.add(2);
//        list.add("a");
//        list.clear();
        verify(list, times(2)).add(anyInt());

        //检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到，所以下面的代码会通过
        verifyNoMoreInteractions(list);
    }

    @Test(expected = NoInteractionsWanted.class)
    public void find_redundant_interaction2() {
        List list2 = mock(List.class);
        list2.add(1);
        list2.add(2);
        verify(list2).add(1);
        //检查是否有未被验证的互动行为，因为add(2)没有被验证，所以下面的代码会失败抛出异常
        verifyNoMoreInteractions(list2);
    }
}
