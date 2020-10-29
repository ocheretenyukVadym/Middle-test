package com.ocheretenyuk;

public class ConsumerRun extends Thread {
    public Consumer consumer;

    public ConsumerRun(Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run(){
        while (true){
            if(!consumer.run()) {
                Thread.yield();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
