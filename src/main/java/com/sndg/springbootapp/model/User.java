package com.sndg.springbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "users")
//@JsonSerialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @Column
    private Long id;

    @Column(name = "telegram_id")
    private Long telegramId;

    public User() {
    }

    public User(Long id, Long telegramId) {
        this.id = id;
        this.telegramId = telegramId;
    }

    public User(String id, String telegramId) {
        this.id = Long.parseLong(id);
        this.telegramId = Long.parseLong(telegramId);
    }

    public Long getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(Long telegramId) {
        this.telegramId = telegramId;
    }

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
                ", telegramId=" + telegramId +
                '}';
    }
}
