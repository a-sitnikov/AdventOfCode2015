package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

/**
 --- Part Two ---

 Now, take the signal you got on wire a, override wire b to that signal, and reset the other wires (including wire a). What new signal is ultimately provided to wire a?

 */
public class day7_2 {

    public static void main(String[] args) throws Exception {

        URL resource = day7_1.class.getClassLoader().getResource("input7.txt");
        if (resource == null) {
            return;
        }

        HashMap<String, Node> circuit = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            while ((s = in.readLine()) != null) {
                addNode(s, circuit);
            }

        }

        Node a = circuit.get("a");
        Integer value_a = a.evaluate(circuit);

        for (Node node : circuit.values()) {
            node.value = null;
        }

        Node node_b = circuit.get("b");
        node_b.value = value_a;
        System.out.println(a.evaluate(circuit));
    }

    public static void addNode(String str, HashMap<String, Node> circuit) {

        //NOT dq -> dr
        //ep OR eo -> eq
        //44430 -> b

        Operation op = new Operation(str);

        Node node = circuit.get(op.output);
        if (node == null) {
            node = new Node();
            node.name = op.output;
            circuit.put(op.output, node);
        }

        if (node.operation == null) {
            node.operation = op;
        }

        for (Object data : op.input) {

            if (data instanceof String) {

                Node parent = circuit.get(data);
                if (parent == null) {
                    parent = new Node();
                    parent.name = (String) data;
                    circuit.put((String) data, parent);
                }

                node.parents.add(parent);
            }
        }

    }
}