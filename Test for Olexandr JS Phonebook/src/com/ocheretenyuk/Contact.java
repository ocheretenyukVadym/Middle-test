package com.ocheretenyuk;

public class Contact {
    private String name;
    private String phone;
    public int id;

    public Contact(String name, String phone) {
        setName(name);
        setPhone(phone);
        this.id = 1+(int)(Math.random()*1000);
    }

    @Override
    public String toString(){
        return getName() + " " + getPhone() + " id: " + this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
