package com.ocheretenyuk;

public class ProducerRun extends Thread {
    public Producer producer;

    public ProducerRun(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run(){
        while (true){
            if (!producer.run()) {
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
