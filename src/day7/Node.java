package day7;

import java.util.HashSet;
import java.util.Set;

public class Node {
    String name;
    Object[] input;
    String operation;
    Integer value;
    Set<Node> parents;

    public Node() {
        this.input = new Object[2];
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
}
