package com.anil.sample.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample
{
    public static void main(String[] args) throws InterruptedException
    {
        AtomicInteger atomicValue = new AtomicInteger(10);

        Thread t1 = new Thread(new MyRunnable("1", atomicValue));

        Thread t2 = new Thread(new MyRunnable("2", atomicValue));
        Thread t3 = new Thread(new MyRunnable("3", atomicValue));
        Thread t4 = new Thread(new MyRunnable("4", atomicValue));
        Thread t5 = new Thread(new MyRunnable("5", atomicValue));
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
        Thread.sleep(1000);
        t4.start();
        Thread.sleep(1000);
        t5.start();
    }

}

class MyRunnable implements Runnable
{
    ThreadLocal<AtomicInteger> value;

    private String name;

    public MyRunnable(String name, AtomicInteger value)
    {
        this.name = name;
        this.value = ThreadLocal.withInitial(() -> value);
    }

    @Override
    public void run()
    {
        System.out.println("Before " + name + " value = " + value.get().get());
        value.set(new AtomicInteger(value.get().get() + 1));
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("After " + name + " value = " + value.get().get());
    }
}
