package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

/**
 --- Day 7: Some Assembly Required ---

 This year, Santa brought little Bobby Tables a set of wires and bitwise logic gates! Unfortunately, little Bobby is a little under the recommended age range, and he needs help assembling the circuit.

 Each wire has an identifier (some lowercase letters) and can carry a 16-bit signal (a number from 0 to 65535). A signal is provided to each wire by a gate, another wire, or some specific value. Each wire can only get a signal from one source, but can provide its signal to multiple destinations. A gate provides no signal until all of its inputs have a signal.

 The included instructions booklet describes how to connect the parts together: x AND y -> z means to connect wires x and y to an AND gate, and then connect its output to wire z.

 For example:

 123 -> x means that the signal 123 is provided to wire x.
 x AND y -> z means that the bitwise AND of wire x and wire y is provided to wire z.
 p LSHIFT 2 -> q means that the value from wire p is left-shifted by 2 and then provided to wire q.
 NOT e -> f means that the bitwise complement of the value from wire e is provided to wire f.

 Other possible gates include OR (bitwise OR) and RSHIFT (right-shift). If, for some reason, you'd like to emulate the circuit instead, almost all programming languages (for example, C, JavaScript, or Python) provide operators for these gates.

 For example, here is a simple circuit:

 123 -> x
 456 -> y
 x AND y -> d
 x OR y -> e
 x LSHIFT 2 -> f
 y RSHIFT 2 -> g
 NOT x -> h
 NOT y -> i

 After it is run, these are the signals on the wires:

 d: 72
 e: 507
 f: 492
 g: 114
 h: 65412
 i: 65079
 x: 123
 y: 456

 In little Bobby's kit's instructions booklet (provided as your puzzle input), what signal is ultimately provided to wire a?

 */
public class day7_1 {

    public static void main(String[] args) throws Exception {

        URL resource = day7_1.class.getClassLoader().getResource("input7.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            HashMap<String, Node> circuit = new HashMap<>();
            while ((s = in.readLine()) != null) {
                addNode(s, circuit);
            }

            Node a = circuit.get("a");
            System.out.println(a.evaluate(circuit));

        }
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

        for (Object data: op.input) {

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