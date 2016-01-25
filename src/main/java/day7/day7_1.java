package day7;

import java.io.BufferedReader;
import java.io.FileReader;
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

        String inputFile = day7_1.class.getClassLoader().getResource("input7.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String s;
        HashMap<String, Node> circuit = new HashMap<>();
        while ((s = in.readLine()) != null) {

            addNode(s, circuit);

        }

        Node a = circuit.get("a");
        System.out.println(evaluate(a, circuit));
    }

    public static void addNode(String str, HashMap<String, Node> circuit) {

        //NOT dq -> dr
        //ep OR eo -> eq
        //44430 -> b

        int ind = str.indexOf("->");
        String ouput = str.substring(ind+2).trim();
        Node node = circuit.get(ouput);
        if (node == null) {
            node = new Node();
            node.name = ouput;
            circuit.put(ouput, node);
        }

        String input = str.substring(0, ind-1).trim();
        String[] array = input.split(" ");
        Object[] inputArray = new String[2];
        int inputNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                node.input[inputNumber] = Integer.valueOf(array[i]);
                inputNumber++;
            } else if (isOperator(array[i])) {
                node.operation = array[i];
            } else {
                node.input[inputNumber] = array[i];
                inputNumber++;

                Node parent = circuit.get(array[i]);
                if (parent == null) {
                    parent = new Node();
                    parent.name = array[i];
                    circuit.put(array[i], parent);
                }

                node.parents.add(parent);
            }
        }

    }

    public static boolean isNumber(String str) {

        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isOperator(String str) {

        if (str.equals("NOT") || str.equals("AND") ||
            str.equals("OR") || str.equals("RSHIFT") ||
            str.equals("LSHIFT")) {
            return true;
        } else {
            return false;
        }
    }

    public static int evaluate(Node node, HashMap<String, Node> circuit) {

        if (node.value != null) {
            return node.value;
        }

        for (Node parent: node.parents) {

            if (parent.value == null) {
                parent.value = evaluate(parent, circuit);
            }
        }

        for (int i = 0; i < node.input.length; i++) {
            if (node.input[i] == null) {
                continue;
            }

            if (node.input[i] instanceof String) {
                Node parent = circuit.get(node.input[i]);
                node.input[i] = parent.value;
            }
        }

        if (node.operation == null) {
            node.value = (Integer) node.input[0];
        } else if (node.operation.equals("NOT")) {
            node.value = ~((Integer) node.input[0]);
        } else if (node.operation.equals("AND")) {
            node.value = (Integer) node.input[0] & (Integer) node.input[1];
        } else if (node.operation.equals("OR")) {
            node.value = (Integer) node.input[0] ^ (Integer) node.input[1];
        } else if (node.operation.equals("RSHIFT")) {
            node.value = (Integer) node.input[0] >>> (Integer) node.input[1];
        } else if (node.operation.equals("LSHIFT")) {
            node.value = (Integer) node.input[0] << (Integer) node.input[1];
        }
        return node.value;
    }
}