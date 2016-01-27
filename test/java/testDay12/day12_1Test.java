package testDay12;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class day12_1Test {

    @Test
    public void testGetSum() throws Exception {

        JsonParser jsonParser;
        int value;

        jsonParser = new JsonFactory().createJsonParser("[1,2,3]");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(6, value);

        jsonParser = new JsonFactory().createJsonParser("{\"a\":2,\"b\":4}");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(6, value);

        jsonParser = new JsonFactory().createJsonParser("[[[3]]]");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(3, value);

        jsonParser = new JsonFactory().createJsonParser("{\"a\":{\"b\":4},\"c\":-1}");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(3, value);

        jsonParser = new JsonFactory().createJsonParser("{\"a\":[-1,1]}");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(0, value);

        jsonParser = new JsonFactory().createJsonParser("[-1,{\"a\":1}]");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(0, value);

        jsonParser = new JsonFactory().createJsonParser("[]");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(0, value);

        jsonParser = new JsonFactory().createJsonParser("{}");
        value = day12.day12_1.getSum(jsonParser);

        assertEquals(0, value);

    }
}