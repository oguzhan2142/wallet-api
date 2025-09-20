package com.oguzhan.wallet.domain.user;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @EmbeddedId
    private UserId id;


    @Embedded
    private Name name;




    protected User() {
    }

    public User(UserId id, Name name) {
        this.id = id;
        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }
}
