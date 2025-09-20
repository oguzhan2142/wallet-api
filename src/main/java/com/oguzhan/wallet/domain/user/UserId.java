package com.oguzhan.wallet.domain.user;

import com.oguzhan.wallet.domain.exceptions.InvalidIdException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable

public record UserId(
        @Column(name = "id")
        UUID value
) {

    public UserId {
        if (value == null) {
            throw new InvalidIdException("Id for this user cannot be null");
        }
    }

    public static UserId newId() {
        return new UserId(UUID.randomUUID());
    }
}
