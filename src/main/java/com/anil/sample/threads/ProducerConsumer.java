package com.anil.sample.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    BlockingQueue<Integer> data = new ArrayBlockingQueue<>(2);
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Runnable producer = () -> {
            int i = 0;
            while(true){
                try {
                    pc.data.put(i);
                    System.out.println("Produced : "+i);
                    Thread.sleep(200);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumer = () -> {
            while(true){
                try {
                    int i = pc.data.take();
                    System.out.println("Consumed : "+i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
