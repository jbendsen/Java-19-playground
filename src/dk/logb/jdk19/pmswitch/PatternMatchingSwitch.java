package dk.logb.jdk19.pmswitch;

public class PatternMatchingSwitch {
    //a method that returns a string
    public static String getTextForNumber(Integer n) {
        return switch (n) {
            case -1, 1 -> "Number is 1 or -1";                 // Special cases
            case Integer i when i > 0 -> "Type is integer, it's > 0";  // Positive integer cases
            case Integer i  -> "It's just an integer";             // All the remaining integers (thus exhaustive)
        };
    }


    public static void main(String[] args) {
        //call getTextForNumber with 1, -1, 0, 2, -2 and print the parameter and the result
        for (int i = -2; i <= 2; i++) {
            System.out.println("getTextForNumber(" + i + ") = " + getTextForNumber(i));
        }
    }
}
