package dk.logb.jdk19;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        printSum(p1);
    }

    record Point(int x, int y) {}

    static void printSum(Object o) {
        if (o instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x+y);
        }
    }


}
