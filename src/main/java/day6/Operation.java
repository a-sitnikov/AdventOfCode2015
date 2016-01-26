package day6;

public class Operation {

    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public String operation;

    public Operation(String str) {

        //turn off 660,55 through 986,197
        //toggle 322,558 through 977,958
        //turn on 226,196 through 599,390

        Integer ind = str.indexOf("through");
        String s2 = str.substring(ind + 7).trim();
        int[] arr = getCoords(s2);
        this.x2 = arr[0];
        this.y2 = arr[1];

        str = str.substring(0, ind).trim();
        ind = str.lastIndexOf(" ");

        this.operation = str.substring(0, ind).trim();
        String s1 = str.substring(ind).trim();
        arr = getCoords(s1);
        this.x1 = arr[0];
        this.y1 = arr[1];

    }

    static int[] getCoords(String str) {

        //906,775
        int ind = str.indexOf(",");
        String s1 = str.substring(0, ind);
        String s2 = str.substring(ind+1);

        return new int[]{Integer.valueOf(s1), Integer.valueOf(s2)};

    }
}
