package dk.logb.jdk17.sealed;

abstract sealed class Season
{
}

final class Spring extends Season {}
final class Summer extends Season {}
final class Autumn extends Season {}
final class Winter extends Season {}


public class SealedClassExample {
    public static void main(String[] args) {
        Season s = new Spring();

        //example showing uses of sealed classes and exhaustiveness checking
        //no default case needed
        //in case of null a npe is thrown
        String str = switch(s) {
            case Spring tsp -> "Spring " ;
            case Summer tsu -> "Summer";
            case Autumn ta -> "Autumn";
            case Winter tw -> "Winter";
        };
        System.out.println(str);

    }
}
