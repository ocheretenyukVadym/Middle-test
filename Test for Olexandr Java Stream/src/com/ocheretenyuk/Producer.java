package com.ocheretenyuk;

import java.util.Scanner;
import java.util.Stack;

public class Producer{
    public Stack<Integer> stack;
    public int stackSize;

    public Producer(Stack<Integer> stack){
        this.stack = stack;
        System.out.print("Stack size: ");
        this.stackSize = new Scanner(System.in).nextInt();
    }

    public boolean run() {
        if (stack.size() < stackSize) {
            int random = (int) (1 + Math.random() * 100);
            stack.push(random);
            System.out.println("Producer produce: " + random);
            return true;
        } else return false;

    }

}
