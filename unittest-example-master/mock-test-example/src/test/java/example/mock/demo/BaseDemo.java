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
public class BaseDemo {
    @Test
    public void doMock() {
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        String o = new String("1");
//        mock.add(o);
        String o2 = new String("1");
        mock.add(o2);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(o);//值调用一次
        verify(mock).clear();
    }


    @Test
    public void verifying_number_of_invocations() {
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        list.add(2);
        //验证是否被调用一次，等效于下面的times(1)
        verify(list).add(1);
        verify(list, times(1)).add(1);
        verify(list, times(2)).add(2); //验证是否被调用2次
        verify(list, never()).add(4); //验证是否从未被调用过
        verify(list, atLeastOnce()).add(1); //验证至少调用一次
        verify(list, atLeast(2)).add(2); //验证至少调用2次
        verify(list, atMost(3)).add(3); //验证至多调用3次
    }


}
