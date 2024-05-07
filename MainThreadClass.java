package PACKAGE_NAME;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainThreadClass {
    private int value = 0 ;


    // A BlockingQueue is a type of queue in Java that supports operations that wait for the queue to become non-empty when retrieving an element,
    // and wait for space to become available in the queue when storing an element.
    // In other words, it provides blocking operations for adding and removing elements from the queue.
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);

    //A ReentrantLock is a type of lock in Java that allows a thread to acquire the lock multiple times.
    // It provides the same basic behavior as the synchronized keyword for controlling access to shared resources but offers more flexibility and features.
    Lock lock = new ReentrantLock();
    public void increment() {
        // when lock is locked , only the thread which hits this will run and no other can run this simultaneously.
        // this block of code is available only after the thread hits unlock
        lock.lock();
        try {
            value += 1;
            if(!queue.offer(value)){
                System.out.println("waiting");
                queue.put(value);
            }
            System.out.println(Thread.currentThread().getName() + " incrementing :" +value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public void incrementImpl(ExecutorService executorService, MainThreadClass j){
        executorService.submit(()->{
            try{
                j.increment();


            }
            catch(Exception e){
                e.printStackTrace();
            }

        });
    }

    public void printImpl(ExecutorService executorService, MainThreadClass j) {
        executorService.submit(()->{
            try{
                try {
                    System.out.println(Thread.currentThread().getName() +" finished: "+queue.take());
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
            finally {
            }
        });
    }
    public static void main(String[] args) {
        MainThreadClass j = new MainThreadClass();
        // thread producer .. this is the place where threads are being produced
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < 100000;i++) {
            // this will create a single thread . we can create multiple single threads and work concurrently
            // executorService = Executors.newSingleThreadExecutor();
            //CompletableFuture<Void>: This part declares the type of CompletableFuture that will be returned.
            // In this case, it's a CompletableFuture that will eventually hold a value of type Void.
            // Since runAsync doesn't return a value, the CompletableFuture's type parameter is Void.
           /* CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                j.incrementImpl(executorService, j);
                j.printImpl(executorService,j);
                    }, executorService);*/
//here threads are being executed.
            executorService.submit(()->{
                j.incrementImpl(executorService,j);
                j.printImpl(executorService,j);
            });

        }


        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            executorService.shutdown();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("duration: "+(endTime-startTime));


    }
}
