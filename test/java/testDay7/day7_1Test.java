package testDay7;

import day7.Node;
import day7.Operation;
import day7.day7_1;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class day7_1Test {

    @Test
    public void testOperation() throws Exception {

        Operation op;
        op = new Operation("NOT dq -> dr");
        assertEquals("NOT", op.operation);
        assertEquals("dr",  op.output);
        assertArrayEquals(new Object[]{"dq"}, op.input);

        op = new Operation("ep OR eo -> eq");
        assertEquals("OR", op.operation);
        assertEquals("eq", op.output);
        assertArrayEquals(new Object[]{"ep", "eo"}, op.input);

        op = new Operation("44430 -> b");
        assertEquals(null, op.operation);
        assertEquals("b", op.output);
        assertArrayEquals(new Object[]{44430}, op.input);

    }

    @Test
    public  void testEvaluate() throws Exception {

        Operation op;
        HashMap<String, Node> circuit = new HashMap<>();

        day7_1.addNode("123 -> x", circuit);
        day7_1.addNode("456 -> y", circuit);
        day7_1.addNode("x AND y -> d", circuit);
        day7_1.addNode("x OR y -> e", circuit);
        day7_1.addNode("x LSHIFT 2 -> f", circuit);
        day7_1.addNode("y RSHIFT 2 -> g", circuit);
        day7_1.addNode("NOT x -> h", circuit);
        day7_1.addNode("NOT y -> i", circuit);

        for(Map.Entry<String, Node> entry : circuit.entrySet()) {
            entry.getValue().evaluate(circuit);
        }

        int value;
        value = circuit.get("d").value;
        assertEquals(72, value);

        value = circuit.get("e").value;
        assertEquals(507, value);

        value = circuit.get("f").value;
        assertEquals(492, value);

        value = circuit.get("g").value;
        assertEquals(114, value);

        // java hasn't unsigned int
        value = circuit.get("h").value;
        assertEquals(-124, value); //65412

        value = circuit.get("i").value;
        assertEquals(-457, value); // 65079

        value = circuit.get("x").value;
        assertEquals(123, value);

        value = circuit.get("y").value;
        assertEquals(456, value);
    }
}