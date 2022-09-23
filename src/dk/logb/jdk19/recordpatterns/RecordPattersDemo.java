package dk.logb.jdk19.recordpatterns;


record Point(int x, int y) {}
enum Color { RED, GREEN, BLUE }
record ColoredPoint(Point p, Color c) {}
record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}


public class RecordPattersDemo {


    public static void main(String[] args) {

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        ColoredPoint cp1 = new ColoredPoint(p1, Color.RED);
        ColoredPoint cp2 = new ColoredPoint(p2, Color.RED);
        Rectangle r1 = new Rectangle(cp1, cp2);

        if (p1 instanceof Point(int x, int y)) {
            x=34;
            System.out.printf("Point (%d, %d)", x, y);
        }

        if (r1 instanceof Rectangle(ColoredPoint(Point(int x1, int y1), Color c1), ColoredPoint(Point(int x2, int y2), Color c2))) {

            System.out.printf("Rectangle (%d, %d), (%d, %d)", x1, y1, x2, y2);
        }



    }
}
