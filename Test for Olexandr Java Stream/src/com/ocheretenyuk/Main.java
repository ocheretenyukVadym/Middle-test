package com.ocheretenyuk;

import java.util.Scanner;
import java.util.Stack;

/*
Задача производитель-потребитель
Создать два потока. Один поток производитель второй потребитель.
Поток "Производитель" кладет в стек случайные числа и выводит сообщение в консоль "Producer produced" + число.
Стек ограничен по размеру
Размер стека задает пользователь
Поток "Потребитель" считывает со стека числа положыные потоком "Производитель" и выводит сообщение в консоль "Consumer consume" + число.
Если стек пуст, поток "Потребитель" должен ждать, пока там появятся данные. Если буфер заполнен полностью,
Поток "Производитель" должен ждать, пока потребитель заберёт данные и место освободится.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Stack<Integer> stack = new Stack();

        System.out.print("Enter stack size: ");
        Producer producer = new Producer(stack, new Scanner(System.in).nextInt());
        Consumer consumer = new Consumer(stack);

        producer.start();
        consumer.start();
    }
}
