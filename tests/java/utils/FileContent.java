package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Presents content of file.
 * @author Vladyslav Dovhopol
 */
public class FileContent {

    private final String path;

    /**
     * @param relativePath Path to file relative to /tests/java/
     */
    public FileContent(String relativePath) {
        path = "tests/java/" + relativePath;
    }

    public String read() throws IOException {
        byte[] jsonBytes = Files.readAllBytes(Paths.get(path));
        return new String(jsonBytes);
    }
}
