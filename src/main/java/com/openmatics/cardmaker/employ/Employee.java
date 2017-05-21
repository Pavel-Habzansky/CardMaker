package com.openmatics.cardmaker.employ;

//TODO object Employee is now immutable
public class Employee {
    private final String name;
    private final String position;
    private final String address;

    public Employee(String name, String position, String address){
        this.name = name;
        this.position = position;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public String getAddress(){
        return address;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", position: "+getPosition()+", address: "+getAddress();
    }

}
