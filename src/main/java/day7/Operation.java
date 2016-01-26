package day7;

public class Operation {

    public Object[] input;
    public String output;
    public String operation;

    public Operation(String str) {

        // x LSHIFT 2 -> f
        // y RSHIFT 2 -> g

        String[] arr = str.split("->");
        this.output = arr[1].trim();

        String[] arr1 = arr[0].trim().split(" ");
        int length = arr1.length-1;
        if (length == 0) length = 1;

        this.input = new Object[length];

        int inputNumber = 0;
        for (String s: arr1) {

            Integer intValue = getIntValue(s);
            if (intValue != null) {
                this.input[inputNumber] = intValue;
                inputNumber++;
            } else if (isOperator(s)) {
                this.operation = s;
            } else {
                this.input[inputNumber] = s;
                inputNumber++;
            }
        }

    }

    public static Integer getIntValue(String str) {

        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return null;
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
}
