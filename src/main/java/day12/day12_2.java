package day12;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.IntNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.TextNode;

import java.io.File;

/**
 --- Part Two ---

 Uh oh - the Accounting-Elves have realized that they double-counted everything red.

 Ignore any object (and all of its children) which has any property with the value "red". Do this only for objects ({...}), not arrays ([...]).

 [1,2,3] still has a sum of 6.
 [1,{"c":"red","b":2},3] now has a sum of 4, because the middle object is ignored.
 {"d":"red","e":[1,2,3,4],"f":5} now has a sum of 0, because the entire structure is ignored.
 [1,"red",5] has a sum of 6, because "red" in an array has no effect.

 */
public class day12_2 {

    public static void main(String[] args) throws Exception {

        int sum = 0;

        String inputFile = day12_1.class.getClassLoader().getResource("input12.txt").getFile();
        JsonParser jsonParser = new JsonFactory().createJsonParser(new File(inputFile));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonParser);

        sum = getSum(node);

        System.out.println(sum);
    }

    public static int getSum(JsonNode node) {

        int sum = 0;

        if (node instanceof IntNode) {

            return node.getIntValue();

        } else if (node instanceof ArrayNode) {

            for (JsonNode child: node) {
                sum += getSum(child);
            }

        } else if (node instanceof ObjectNode) {

            for (JsonNode child: node) {
                if (child instanceof TextNode) {
                    String value = child.getTextValue();
                    if (value.equals("red")) {
                        return 0;
                    }
                }
                sum += getSum(child);
            }

        }

        return sum;
    }
}
