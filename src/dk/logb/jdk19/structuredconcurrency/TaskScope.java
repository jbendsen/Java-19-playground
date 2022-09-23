package dk.logb.jdk19.structuredconcurrency;

//include module jdk.incubator.concurrent

//import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskScope {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
/*
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> user  = scope.fork(() -> findUser());
            Future<Integer> order = scope.fork(() -> fetchOrder());

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
        }
*/
    }

    private static int  fetchOrder() {
        return 42;
    }

    private static String findUser() {
        return "User 0";
    }
}
