package dk.logb.jdk17.sealed;

sealed interface Expr
        permits ConstantExpr, PlusExpr, TimesExpr, NegExpr {
    int value();
}

final class ConstantExpr implements Expr {
    private final int value;

    public ConstantExpr(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}

final class PlusExpr implements Expr {
    Expr e1, e2;

    public PlusExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int value() {
        return e1.value() + e2.value();
    }
}

final class TimesExpr implements Expr {
    Expr e1, e2;

    public TimesExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int value() {
        return e1.value() * e2.value();
    }
}

final class NegExpr implements Expr {
    Expr e;

    public NegExpr(Expr e) {
        this.e = e;
    }

    public int value() {
        return -e.value();
    }
}


public class SealedInterfaceExample {
    public static void main(String[] args) {
        Expr e1 = new PlusExpr(new ConstantExpr(1), new ConstantExpr(2));
        Expr e2 = new TimesExpr(new ConstantExpr(4), new ConstantExpr(8));
        Expr e3 = new PlusExpr(e1, e2);
        Expr e4 = new NegExpr(e3);
        System.out.println(asString(e4) + " = " + e4.value());


    }


    public static String asString(Expr e) {
        String s = switch(e) {
            case ConstantExpr c -> ""+c.value();
            case PlusExpr p -> asString("(", p ,")");
            case TimesExpr t -> asString("(", t ,")");
            case NegExpr n ->  asString("", n ,"");
        };
        return s;
    }


    //this method is used to create a string representation of an expression
    private static String asString(String s1, Expr e, String s2) {
        String s = switch(e) {
            case ConstantExpr c -> ""+c.value();
            case PlusExpr p -> s1 + asString("(", p.e1, ")") + " + " + asString("(" , p.e2 , ")") + s2;
            case TimesExpr t -> s1 + asString("(", t.e1, ")") + " * "  + asString("(" , t.e2 , ")") + s2;
            case NegExpr n -> s1 + asString("-(", n.e, ")") + s2;
        };
        return s;
    }
}


