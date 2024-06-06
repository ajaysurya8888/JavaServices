package PACKAGE_NAME;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/// future.complete na adhu pana nenacha velaya complete paniduchu nu artham.

//idhu complete paniduchu na ..subscriber adha get panika mudiyum with same object

// Publisher class responsible for publishing messages
class Publisher {


    // Publish a message by completing the CompletableFuture with the message
    public CompletableFuture<String> publish(String message) throws InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(2000); //even sleep is there , it will work received only idk why
        future.complete(message);
        return future;
    }

}

// Subscriber class responsible for subscribing to messages
class Subscriber {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    // Subscribe to messages by asynchronously waiting for the CompletableFuture to complete
    // Subscribe to messages by asynchronously waiting for the CompletableFuture to complete
/*    public void subscribe(CompletableFuture<String> future) {
//without any time limit this will wait for message to come .
        future.thenAccept(message -> {
            System.out.println("Subscriber " + name + " received message: " + message);
        });
    }*/

    // Subscribe to messages by asynchronously waiting for the CompletableFuture to complete
    public void subscribe(CompletableFuture<String> future) {
        try {
            String message = future.get(0, TimeUnit.MILLISECONDS);
            System.out.println("Subscriber " + name + " received message: " + message);
        } catch (TimeoutException e) {
            System.out.println("Subscriber " + name + " did not receive message within 1 second");
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }


}

public class CompletableFutureImpl {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        // Subscribe subscribers to the publisher's CompletableFuture


        // Publish messages asynchronously
        new Thread(() -> {
            for (int i = 1; i <=10; i++) {
                String message = "Message " + i;
                System.out.println("Publishing: " + message);
                CompletableFuture<String> future = null;
                try {
                    future = publisher.publish(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                subscriber1.subscribe(future);
                subscriber2.subscribe(future);
// Simulate delay between messages
            }
        }).start();
    }
}
