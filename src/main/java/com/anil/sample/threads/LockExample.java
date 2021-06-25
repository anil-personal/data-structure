package com.anil.sample.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        sharedData.setIntValue(1);
        sharedData.setStringValue("1");

        int availableProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Processor = " + availableProcessor);
        for (int i = 0; i < availableProcessor; i++) {
            new Thread(new LockableRunnable(i, sharedData)).start();
        }
    }
}

class SharedData {
    private int intValue;
    private String stringValue;
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public void updateValues() throws InterruptedException {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.tryLock(500, TimeUnit.MICROSECONDS);
        if (readWriteLock.isWriteLockedByCurrentThread()) {
            System.out.println("Write Lock = " + Thread.holdsLock(readWriteLock) + ", Read Lock Count =" + readWriteLock.getReadHoldCount());
            System.out.println("Before Updating : " + getIntValue() + ", " + getStringValue());
            setIntValue(getIntValue() + 1);
            Thread.sleep(500);
            setStringValue(Integer.toString(getIntValue()));
            System.out.println("After Updating : " + getIntValue() + ", " + getStringValue());
            writeLock.unlock();
        } else {
            System.out.println("WriteLock is not held by current Thread. So, just Reading ");
            readWriteLock.readLock();
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            readLock.lock();
            System.out.println("Just Reading : " + getIntValue() + ", " + getStringValue());
            readLock.unlock();
        }
    }

}

class LockableRunnable implements Runnable {
    private int threadId;
    private SharedData sharedData;

    public LockableRunnable(int theadId, SharedData sharedData) {
        this.threadId = theadId;
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                sharedData.updateValues();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

