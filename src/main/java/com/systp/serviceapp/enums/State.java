package com.systp.serviceapp.enums;


import lombok.Getter;

@Getter

public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String state;

    State(final String state){
        this.state = state;
    }



    @Override
    public String toString(){
        return this.state;
    }


}

