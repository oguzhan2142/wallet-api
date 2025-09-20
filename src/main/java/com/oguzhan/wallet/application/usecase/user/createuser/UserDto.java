package com.oguzhan.wallet.application.usecase.user.createuser;

import com.oguzhan.wallet.domain.user.User;

import java.util.UUID;

public record UserDto(UUID id, String firstName, String middleName, String lastName) {


    public static UserDto fromUserEntity(User user) {

        return new UserDto(
                user.getId().value(),
                user.getName().firstName(),
                user.getName().middleName(),
                user.getName().lastName()
        );
    }
}
