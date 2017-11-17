package com.systp.serviceapp.enums;

public enum UserProfileType {
    ADMIN("ADMIN"),
    GRAND_USER("GRAND_USER"),
    USER("USER");

    String type;

    UserProfileType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    @Override
    public String toString(){
        return this.type;
    }

    public String getName(){
        return this.name();
    }
}
