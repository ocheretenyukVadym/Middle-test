package com.ocheretenyuk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> allUsers = new ArrayList();
        boolean work = true;
        String login, password;
        Scanner sc = new Scanner(System.in);
        System.out.print("Sing in/Create account (S/C): ");
        while(work) {
            jump:
            switch (new Scanner(System.in).nextLine()) {
                case "S":
                    System.out.print("Enter login: ");
                    login = sc.nextLine();
                    System.out.print("Enter password: ");
                    password = sc.nextLine();
                    for (User user : allUsers) {
                        if (user.getLogin().equals(login) & user.getPassword().equals(password)) {
                            if (user.menu()) {
                                System.out.print("Sing in/Create account (S/C): ");

                            }
                        }
                    }
                    System.out.println("User not found");
                    System.out.print("Sing in/Create account (S/C): ");
                    break jump;
                case "C":
                    System.out.print("Enter login: ");
                    login = sc.nextLine();
                    System.out.print("Enter password: ");
                    password = sc.nextLine();
                    User newUser = new User(login, password);
                    allUsers.add(newUser);
                    if(newUser.menu()) {
                        System.out.print("Sing in/Create account (S/C): ");
                        break jump;
                    }
                default:
                    System.out.println("Not find command");
            }
        }
    }

}

