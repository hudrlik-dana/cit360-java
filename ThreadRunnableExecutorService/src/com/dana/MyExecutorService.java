package com.dana;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

// working with the reentrant lock and unlock
public class MyExecutorService {

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();

        // lock is reentrant if thread is holding a reentrant lock
        // when it reaches code that requires the same lock it can continue
        // executing it doesn't need to obtain the lock again

        ReentrantLock bufferLock = new ReentrantLock();

// thread pools
// create the executive service fixed thread pool, pass a set number of threads
        ExecutorService myExecutorService = Executors.newFixedThreadPool(3);

        // pass the bufferLock to aProducer and aConsumer objects
        MyProducer aProducer = new MyProducer(buffer,  bufferLock, ThreadColors.ANSI_CYAN);
        MyConsumer aConsumer1 = new MyConsumer(buffer, bufferLock, ThreadColors.ANSI_RED);
        MyConsumer aConsumer2 = new MyConsumer(buffer, bufferLock, ThreadColors.ANSI_BLUE);
/*

// reentrant lock and unlock
        new Thread(aProducer).start();
        new Thread(aConsumer1).start();
        new Thread(aConsumer2).start();
*/

// thread pools - vital for large number of threads, jvm optimize thread management
        myExecutorService.execute(aProducer);
        myExecutorService.execute(aConsumer1);
        myExecutorService.execute(aConsumer2);

// submit() accepts callable object similar to runnable object
// submit() returns the value as an object of type future

        Future<String> future = myExecutorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(ThreadColors.ANSI_GREEN + "Hey I'm from the Callable class");
                return "Here is my callable result";
            }
        });

        // get the result
        // future.get() blocks until result is available
        // if called from main thread application frozen until results available
        // remember do not use future.get() in UI app - because it does not use
        // services in java.util.concurrent package if working in javafx
        // instead use classes in javafx.concurrent package
        // to run tasks in background threads to process results

        // wrap in a try catch block that catches execution exception error,
        // interruption exception error
        try {
            System.out.println(future.get());

            // execution exception message
        } catch(ExecutionException executionExceptionError) {
            System.out.println("Something did not go right");
            // catch interrupted exception message
        } catch(InterruptedException interruptedExceptionError) {
            System.out.println("The thread running this task was interrupted");
        }

// waits for executing services to terminate
        // shutdown() is orderly - use this most times
        // shutdownNow() immediate termination, stop remaining tasks or any in the que
        myExecutorService.shutdown();

    }
}
// aProducer and aConsumer threads run and then the callable code
// callable code doesn't run while aProducer is sleeping and aConsumers are looping
// because service fixedThreadPool has a maximum of 3 active threads
// callable waited till the other methods finished



// MyProducer class implements Runnable interface to run on a background thread
class MyProducer implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;
    private String color;

    // constructor accepts the buffer
    // shares the buffer with aConsumers, color prints to console, bufferLock
    public MyProducer(List<String> buffer, ReentrantLock bufferLock, String color) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
        this.color = color;
    }

    public void run() {
        Random aRandom = new Random();
        String[] numbers = { "1", "2", "3", "4", "5"};

        for(String number: numbers) {

            try {
                System.out.println(color + "Adding..." + number);
                // lock the buffer, add the number, unlock buffer
                // avoid interference, need to release the lock
                bufferLock.lock();

                // try-finally block
                try {
                    // update the arrayList
                    buffer.add(number);

                    // unlock in the finally clause
                } finally {
                    bufferLock.unlock();
                }
                // thread sleeping for 3 seconds
                Thread.sleep(aRandom.nextInt(3000));

            } catch(InterruptedException interruptedException) {
                System.out.println("My aProducer thread was interrupted");
            }
        }

        System.out.println(color + "Adding to the End Of File then exiting...");
        // lock the buffer, add end-of-file, unlock buffer
        // avoid interference, need to release the lock
        bufferLock.lock();
/*
// reentrant lock and unlock
        buffer.add("EOF");
        bufferLock.unlock();
    }
}
 */
        // try finally block
        try {
            // update arrayList
            buffer.add("EOF");

            // unlock the bufferLock in the finally clause
        } finally {
            bufferLock.unlock();
        }
    }
}

// MyConsumer class implements Runnable interface to run on a background thread
class MyConsumer implements Runnable {
    private static final String EOF = "EOF";
    private List<String> buffer;
    private ReentrantLock bufferLock;
    private String color;

// constructor accepts the buffer
// shares the buffer with aProducer, color prints to console, bufferLock
    public MyConsumer(List<String> buffer, ReentrantLock bufferLock, String color) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
        this.color = color;
    }

    // try finally block
    public void run() {
        // local variable
        int count = 0;

        while(true) {
            // if a lock is available, get lock and continue through code
            if(bufferLock.tryLock()) {
                // try finally block
                try {
                    // test to see if the buffer is empty
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The count = "+ count);

                    // reset count to 0
                    count = 0;

                    // when the buffer is at the end of file exit
                    if(buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exit");
                        break;
                    // when buffer is not at the end of file remove i
                    } else {
                        System.out.println(color + "Remove " + buffer.remove(0));
                    }
                    // unlock in finally clause
                } finally {
                    bufferLock.unlock();
                }
                // if try lock is false, its not able to get a lock, increment count
            } else {
                count++;
            }
        }
    }
}
