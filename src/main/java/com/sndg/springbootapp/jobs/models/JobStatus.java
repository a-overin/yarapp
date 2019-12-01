package com.sndg.springbootapp.jobs.models;

public enum JobStatus {
    Create(0),
    Success(1),
    Unsuccess(2);

    private final int id;

    private JobStatus(final int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static JobStatus getStatusForId(final int id){
        for(final JobStatus status : values())
            if (status.id == id)
                return status;
        return null;
    }
}
