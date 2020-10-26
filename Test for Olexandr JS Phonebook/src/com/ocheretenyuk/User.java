package com.ocheretenyuk;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String login;
    private String password;
    public ArrayList<Contact> contacts = new ArrayList();
    public User(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public boolean menu(){
        System.out.print("Add contact, Delete contact, Show all, Sing out (A/D/S/O): ");
        switch (new Scanner(System.in).nextLine()){
            case "A":
                System.out.print("Name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Phone: ");
                String phone = new Scanner(System.in).nextLine();
                contacts.add(new Contact(name, phone));
                this.menu();
                break;
            case "D":
                System.out.print("Enter id: ");
                int id = new Scanner(System.in).nextInt();
                for(Contact contact: contacts){
                    if(contact.id == id) {
                        contacts.remove(contact);
                        System.out.println("Done!");
                        break;
                    }
                    else{
                        System.out.println("Not found!");
                    }
                }
                this.menu();
                break;
            case "S":
                showAllContacts();
                this.menu();
                break;
            case "O":
                return true;
            default:
                System.out.println("Don`t find command!");
                this.menu();

        }
        return true;
    }

    public void showAllContacts(){
        for (Contact contact: contacts){
            System.out.println(contact.toString());
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
