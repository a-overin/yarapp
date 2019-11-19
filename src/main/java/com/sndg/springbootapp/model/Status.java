package com.sndg.springbootapp.model;

public enum Status {
    Create(0),
    Success(1),
    Unsuccess(2);

    private final int id;

    private Status(final int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Status getStatusForId(final int id){
        for(final Status status : values())
            if (status.id == id)
                return status;
        return null;
    }
}
