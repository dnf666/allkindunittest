package example.demo;

import org.junit.*;
import org.junit.runner.RunWith;



/**
 * Created by wangxun on 2016/5/5.
 */
//@RunWith(org.junit.runners.JUnit4.class)
public class JunitDemoTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }

    //execute only once, in the end
    @AfterClass
    public static void  afterClass() {
        System.out.println("in after class");
    }

    //execute for each test, before executing test
    @Before
    public void before() {
        System.out.println("in before");
    }

    //execute for each test, after executing test
    @After
    public void after() {
        System.out.println("in after");
    }

    //test case 1
    @Test
    public void testCase1() {
        System.out.println("in test case 1");
    }

    //test case 2
    @Test
    public void testCase2() {
        System.out.println("in test case 2");
    }
    //test case 3忽略测试
    @Ignore
    @Test
    public void testCase3() {
        System.out.println("in test case 3");
    }

    //异常测试
    @Test(expected = RuntimeException.class)
    public void testCase4() {
        throw new RuntimeException();
    }

    //时间测试
    @Test(timeout=100)//10ms执行不完
    public void testCase5() {
        System.out.println("in test case 5:start");
        long count = 10000;
        count *= count;
        while (count-- > 0){
        }
        System.out.println("in test case 5:end");
    }
}
