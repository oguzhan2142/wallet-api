package com.oguzhan.wallet.api.requests;

import com.oguzhan.wallet.application.usecase.user.createuser.CreateUserCommand;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName) {

    public CreateUserCommand toCommand() {
        return new CreateUserCommand(firstName, middleName, lastName);
    }
}
