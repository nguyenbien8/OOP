import java.util.*;

public class Distance {
    public static void main(String[] args) {
        double num1 = Integer.parseInt(args[0]);
        double num2 = Integer.parseInt(args[1]);
        double distance = Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2));
        System.out.printf("%.2f", distance);
    }
}
