package example.mock.demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
* /**
* Created by Administrator on 15-7-16.
*/
public class SpyDemo {//partial mock used spy or doCallRealMethod

    @Test
    public void doMock() {
        List<String> list = new LinkedList<String>();
        List<String> spy = spy(list);
        when(spy.size()).thenReturn(100);//与doReturn()when()什么区别？继续看
        spy.add("one");
        spy.add("two");
        assertThat(spy.get(0).equals("one")).isEqualTo(true);
        assertThat(spy.size() == 100).isEqualTo(true);
//        spy.size()通过桩实现返回了值100，而spy.get(0)则返回了实际值。

    }

    //when()thenReturn与doReturn()when()区别
    @Test
    public void spyTest() {
        Jack spyJack = spy(new Jack());
        when(spyJack.go()).thenReturn(false);
        System.out.println("after stub");
        spyJack.go();
        assertThat(spyJack.go()).isEqualTo(false);
    }

    @Test
    public void spyTest2() {
        Jack spyJack = spy(new Jack());
//        spyJack.go();
        doReturn(false).when(spyJack).go();
        System.out.println("after stub");
        spyJack.go();
        assertThat(spyJack.go()).isEqualTo(false);
    }

    class Jack {
        public boolean go() {
            System.out.println("I am Jack, Let's go!");
            return true;
        }
    }


    @Test
    public void callRealMethodTest() {
        Jerry jerry = mock(Jerry.class);
        doCallRealMethod().when(jerry).goHome();
        doCallRealMethod().when(jerry).doSomeThingB();
        jerry.goHome();
        verify(jerry , times(1)).doSomeThingA();//方法A会调用
        verify(jerry , times(1)).doSomeThingB();
    }
    class Jerry {
        public void goHome() {
            doSomeThingA();
            doSomeThingB();
        }
        // real invoke it.
        public void doSomeThingB() {
            System.out.println("doSomeThingB");
        }
        // auto mock method by mockito
        public void doSomeThingA() {//不会执行真实方法
            System.out.println("doSomeThingA");

        }
    }


}
