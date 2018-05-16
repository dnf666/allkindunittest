package example.powermock.demo.staticmethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
//We prepare the IdGenerator for test because the static method is normally not mockable
@PrepareForTest(IdGenerator.class)
public class StaticMethodDemo {
    @Test
    public void demoStaticMethodMocking() throws Exception {
        PowerMockito.mockStatic(IdGenerator.class);
        PowerMockito.when(IdGenerator.generateNewId()).thenReturn(1);
        int mockResult = IdGenerator.generateNewId();
        assertThat(mockResult == 1).isEqualTo(true);
    }
}
