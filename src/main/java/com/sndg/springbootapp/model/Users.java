package com.sndg.springbootapp.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                '}';
    }
}
