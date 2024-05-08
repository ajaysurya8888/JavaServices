package PACKAGE_NAME;

import java.util.concurrent.*;

// Publisher class responsible for publishing messages
class Publisher {
    // Executor for introducing a delay
    private final Executor delayedExecutor = CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS);

    // Publish a message by completing the CompletableFuture with the message after a time delay
    public CompletableFuture<String> publish(String message) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Introduce a delay of 2 seconds
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return message;
        }, delayedExecutor);
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
            String message = future.get(1000, TimeUnit.MILLISECONDS);
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
                future = publisher.publish(message);
                subscriber1.subscribe(future);
                subscriber2.subscribe(future);
// Simulate delay between messages
            }
        }).start();
    }
}
