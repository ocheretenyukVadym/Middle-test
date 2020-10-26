package com.ocheretenyuk;

import java.util.Stack;


public class Consumer  extends Thread {
    public Stack<Integer> stack;

    public Consumer(Stack<Integer> stack){
        this.stack = stack;
    }

    @Override
    public void run(){
        for(int i = 0; i<10000; i++)
            while (stack.size() >= 0) {
                for (int j = 0; j < stack.size(); j++) {
                    System.out.println("Consumer consume " + stack.get(i));
                    stack.remove(stack.get(i));
                }
            }

    }
}
