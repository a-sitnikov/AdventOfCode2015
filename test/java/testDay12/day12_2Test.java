package testDay12;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msk5446 on 27.01.2016.
 */
public class day12_2Test {

    @Test
    public void testGetSum() throws Exception {

        JsonParser jsonParser;
        int value;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node;

        jsonParser = new JsonFactory().createJsonParser("[1,2,3]");
        node = mapper.readTree(jsonParser);
        value = day12.day12_2.getSum(node);
        assertEquals(6, value);

        jsonParser = new JsonFactory().createJsonParser("[1,{\"c\":\"red\",\"b\":2},3]");
        node = mapper.readTree(jsonParser);
        value = day12.day12_2.getSum(node);
        assertEquals(4, value);

        jsonParser = new JsonFactory().createJsonParser("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}");
        node = mapper.readTree(jsonParser);
        value = day12.day12_2.getSum(node);
        assertEquals(0, value);

        jsonParser = new JsonFactory().createJsonParser("[1,\"red\",5]");
        node = mapper.readTree(jsonParser);
        value = day12.day12_2.getSum(node);
        assertEquals(6, value);

    }
}