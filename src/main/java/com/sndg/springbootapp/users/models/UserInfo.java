package com.sndg.springbootapp.users.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "info_name"})})
@JsonSerialize
public class UserInfo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @NotNull
    User user;

    @Column(name = "info_name")
    @NotNull
    String infoName;

    @Column(name = "info_value")
    @NotNull
    String infoValue;

    public UserInfo() {
    }

    public UserInfo(@NotNull User user, @NotNull String infoName, @NotNull String infoValue) {
        this.user = user;
        this.infoName = infoName;
        this.infoValue = infoValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getInfoValue() {
        return infoValue;
    }

    public void setInfoValue(String infoValue) {
        this.infoValue = infoValue;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", user=" + user +
                ", infoName='" + infoName + '\'' +
                ", infoValue='" + infoValue + '\'' +
                '}';
    }
}
