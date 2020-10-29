package com.ocheretenyuk;

import java.util.Stack;


public class Consumer{
    public Stack<Integer> stack;

    public Consumer(Stack<Integer> stack){
        this.stack = stack;
    }

    public boolean run(){
        if (stack.size() > 0){
            System.out.println("Consumer consume " + stack.lastElement());
            stack.pop();
            return true;
        } else return false;
    }
}
