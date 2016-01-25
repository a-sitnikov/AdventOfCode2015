package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 --- Part Two ---

 Now, take the signal you got on wire a, override wire b to that signal, and reset the other wires (including wire a). What new signal is ultimately provided to wire a?

 */
public class day7_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = day7_1.class.getClassLoader().getResource("input7.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String s;
        HashMap<String, Node> circuit = new HashMap<>();
        while ((s = in.readLine()) != null) {

            addNode(s, circuit);

        }

        Node a = circuit.get("a");
        Integer value_a = evaluate(a, circuit);

        for (Node node : circuit.values()) {
            node.value = null;
        }

        Node node_b = circuit.get("b");
        node_b.value = value_a;
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
                node.calculatedInput[i] = parent.value;
            } else {
                node.calculatedInput[i] = (Integer) node.input[i];
            }
        }

        if (node.operation == null) {
            node.value = node.calculatedInput[0];
        } else if (node.operation.equals("NOT")) {
            node.value = ~(node.calculatedInput[0]);
        } else if (node.operation.equals("AND")) {
            node.value = node.calculatedInput[0] & node.calculatedInput[1];
        } else if (node.operation.equals("OR")) {
            node.value = node.calculatedInput[0] ^ node.calculatedInput[1];
        } else if (node.operation.equals("RSHIFT")) {
            node.value = node.calculatedInput[0] >>> node.calculatedInput[1];
        } else if (node.operation.equals("LSHIFT")) {
            node.value = node.calculatedInput[0] << node.calculatedInput[1];
        }
        return node.value;
    }
}