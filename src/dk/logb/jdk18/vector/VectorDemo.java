package dk.logb.jdk18.vector;


import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

// /usr/lib/jvm/jdk-19/bin/javac --enable-preview --release 19 --add-modules jdk.incubator.vector ./src/dk/logb/jdk18/vector/VectorDemo.java
// /usr/lib/jvm/jdk-19/bin/java --enable-preview  --add-modules jdk.incubator.vector -cp ./src dk.logb.jdk18.vector.VectorDemo


public class VectorDemo {
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    public static void main(String[] args) {
        float[] a = new float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f};
        float[] b = new float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f};
        float[] c = new float[100];
        vectorComputation(a, b, c);
        for (int j = 0; j < c.length; j++) {
            System.out.println(c[j]);
        }
        int[] ia = new int[] {1, 5, 10, 20, 30, 40, 7, 8, 9, 100};
        int[] ib = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var ci = vectorCalc(ia, ib);
        for (int j = 0; j < ci.length; j++) {
            System.out.println(ci[j]);
        }


    }

    public static int[] vectorCalc(int[] a, int[] b) {
        VectorSpecies<Integer> SPECIESINT = IntVector.SPECIES_PREFERRED;

        var c = new int[a.length];
        var upperBound = SPECIESINT.loopBound(a.length);

        var i = 0;
        for (; i < upperBound; i += SPECIESINT.length()) {
            var va = IntVector.fromArray(SPECIESINT, a, i);
            var vb = IntVector.fromArray(SPECIESINT, b, i);
            var vc = va.add(vb); //.neg(); //mul(va.add(vb.mul(vb)).neg();
            vc.intoArray(c, i);
        }

        // Compute elements not fitting in the vector alignment.
        for (; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }

        return c;

    }
    static void vectorComputation(float[] a, float[] b, float[] c) {
        int i = 0;
        int upperBound = SPECIES.loopBound(a.length);
        System.out.println(i);
        for (; i < upperBound; i += SPECIES.length()) {
            // FloatVector va, vb, vc;
            System.out.println("---" + i);
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            var vc = va.mul(va)
                    .add(vb.mul(vb))
                    .neg();
            vc.intoArray(c, i);
        }
        //print c

    }

}
