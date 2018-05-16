package example.mock.demo;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Administrator on 15-7-16.
 */
public class AnswerDemo {
    @Test
    public void doMock() {
        List mockList = mock(List.class);
        //使用Answer来生成我们我们期望的返回
        when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return "hello world:" + args[0];
            }
        });
        assertThat(mockList.get(0).equals("hello world:0")).isEqualTo(true);
        assertThat(mockList.get(999).equals("hello world:999")).isEqualTo(true);

    }


    @Test
    public void customAnswerTest() {
        List<String> mock = mock(List.class);
        doAnswer(new CustomAnswer()).when(mock).get(anyInt());
//        mock.get(2);
        //
        assertThat( mock.get(4).equals("yes")).isEqualTo(true);
//        mock.get(4);
    }
}

class CustomAnswer implements Answer<String> {
    public String answer(InvocationOnMock invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        Integer num = (Integer) args[0];
        if (num > 3) {
            return "yes";
        } else {
            throw new RuntimeException();
        }
    }


}
