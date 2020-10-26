package com.ocheretenyuk;

import java.util.Stack;

public class Producer extends Thread {
    public Stack<Integer> stack;
    public int stackSize;

    public Producer(Stack<Integer> stack, int stackSize){
        this.stack = stack;
        this.stackSize = stackSize;
    }

    @Override
    public void run(){
        for(int i = 0; i<100000; i++) {
            while (stack.size() <= this.stackSize) {
                int random = (int) (1 + Math.random() * 100);
                stack.push(random);
                System.out.println("Producer produced " + random);
            }
        }
    }
}
