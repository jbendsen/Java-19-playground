package dk.logb.jdk19.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        //start 10K threads that sleep for 1 second
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }  // executor.close() is called implicitly, and waits

        var end = System.currentTimeMillis();
        System.out.println("Time in ms (virtual): " + (end - start));

        start = System.currentTimeMillis();

        try (var executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }


        end = System.currentTimeMillis();
        System.out.println("Time in ms (fixed): " + (end - start));


    }
}


