package example.powermock.demo.constructedfunction;

import java.io.File;

/**
 * Created by Administrator on 15-7-16.
 */
public class DirectoryStructure {
    public boolean create(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            throw new IllegalArgumentException(
                    "\"" + directoryPath + "\" already exists.");
        }

        return directory.mkdirs();
    }
}