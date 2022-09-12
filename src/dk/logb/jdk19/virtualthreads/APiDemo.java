package dk.logb.jdk19.virtualthreads;

import java.util.Map;

public class APiDemo {
    public static void main(String[] args) {
        //create a virtual thread
        Thread thread = Thread.ofVirtual().start(() -> {
            System.out.println("Hello from a virtual thread");
        });

        //new methods in class Thread: threadId, isVirtual
        System.out.println("Thread " + thread.threadId() + " is virtual: " + thread.isVirtual());

        //get all platform threads
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        allStackTraces.forEach((t, st) -> {
            System.out.println("Thread " + t.threadId() + " is virtual: " + t.isVirtual());
        });
        System.out.println("We didn't see Thread " + thread.threadId() + " because it is a virtual thread");


        //wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
