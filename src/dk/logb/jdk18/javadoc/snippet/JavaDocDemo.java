package dk.logb.jdk18.javadoc.snippet;

import java.util.Optional;

public class JavaDocDemo {
    public static void main(String[] args) {
        System.out.println(add(1, 2));

    }



    /**
     * The following code shows how to use {@code JavaDocDemo.add(int, int)}.
     * {@snippet :
     * int i = add(1, 2)
     * assert i == 3;
     * }
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * The following code shows how to use {@code Optional.isPresent}:
     * {@snippet file="ShowOptional.java" region="example"}
     */
    public void show(Optional<String> v) {
        if (v.isPresent()) {
            System.out.println("v: " + v.get());
        }
    }
}
