package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Vladyslav Dovhopol
 */
public final class JsonFileContent {

    private final FileContent fileContent;

    /**
     * @param relativePath Path to file relative to /tests/java/
     */
    public JsonFileContent(String relativePath) {
        fileContent = new FileContent(relativePath);
    }

    public JsonNode read() throws IOException {
        String jsonString = fileContent.read();
        return new ObjectMapper().reader().readTree(jsonString);
    }
}
