package example.powermock.demo.constructedfunction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.File;

/**
 * Created by Administrator on 15-7-16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DirectoryStructure.class)
public class DirectoryStructureTest {
    @Test
    public void createDirectoryStructureWhenPathDoesntExist() throws Exception {
        final String directoryPath = "mocked path";

        File directoryMock = mock(File.class);

        // This is how you tell PowerMockito to mock construction of a new File.
        whenNew(File.class).withArguments(directoryPath).thenReturn(directoryMock);

        // Standard expectations
        when(directoryMock.exists()).thenReturn(false);
        when(directoryMock.mkdirs()).thenReturn(true);

//        new DirectoryStructure().create(directoryPath);
        assertThat(new DirectoryStructure().create(directoryPath)).isEqualTo(true);
        // Optionally verify that a new File was "created".
        verifyNew(File.class).withArguments(directoryPath);
    }
}