package example.powermock.demo.privatemethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.*;
/**
 * Created by Administrator on 15-7-16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivatePartialMockingExample.class)
public class PrivatePartialMockingExampleTest {
    @Test
    public void demoPrivateMethodMocking() throws Exception {
        final String expected = "TEST VALUE";
        final String nameOfMethodToMock = "privateMethod";
        final String input = "input";

        PrivatePartialMockingExample spyPrivatePartialMockingExample = PowerMockito.spy(new PrivatePartialMockingExample());

        /*
         * Setup the expectation to the private method using the method name
         */
        when(spyPrivatePartialMockingExample, nameOfMethodToMock, input).thenReturn(expected);

        Assert.assertEquals(expected, spyPrivatePartialMockingExample.methodToTestPrivate());

        // Optionally verify that the private method was actually called
        verifyPrivate(spyPrivatePartialMockingExample).invoke(nameOfMethodToMock, input);
    }
}