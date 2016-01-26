package day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Node{

    public String name;
    public Operation operation;
    public Integer[] calculatedInput;
    public Integer value;
    public Set<Node> parents;

    public Node() {
        this.calculatedInput = new Integer[2];
        this.parents  = new HashSet<>();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Integer evaluate(HashMap<String, Node> circuit) {

        if (this.value != null) return this.value;

        for (Node parent: this.parents) {

            if (parent.value == null) {
                parent.evaluate(circuit);
            }
        }

        for (int i = 0; i < this.operation.input.length; i++) {
            if (this.operation.input[i] == null) {
                continue;
            }

            if (this.operation.input[i] instanceof String) {
                Node parent = circuit.get(this.operation.input[i]);
                this.calculatedInput[i] = parent.value;
            } else {
                this.calculatedInput[i] = (Integer) this.operation.input[i];
            }
        }

        if (this.operation.operation == null) {
            this.value = this.calculatedInput[0];
        } else if (this.operation.operation.equals("NOT")) {
            this.value = ~(this.calculatedInput[0]);
        } else if (this.operation.operation.equals("AND")) {
            this.value = this.calculatedInput[0] & this.calculatedInput[1];
        } else if (this.operation.operation.equals("OR")) {
            this.value = this.calculatedInput[0] | this.calculatedInput[1];
        } else if (this.operation.operation.equals("RSHIFT")) {
            this.value = this.calculatedInput[0] >>> this.calculatedInput[1];
        } else if (this.operation.operation.equals("LSHIFT")) {
            this.value = this.calculatedInput[0] << this.calculatedInput[1];
        }

        return this.value;
    }
}
