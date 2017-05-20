package infrastructure.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Vladyslav Dovhopol
 */
public class IntToBooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String rawValue = parser.getText();
        int intValue = rawValue.isEmpty() ? 0 : Integer.valueOf(rawValue);
        return intValue != 0;
    }
}
