package com.oguzhan.wallet.application.usecase.user.createuser;

import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.domain.user.Name;
import com.oguzhan.wallet.domain.user.User;
import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.user.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CreateUserUseCase implements UseCase<CreateUserCommand, UserDto> {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDto handle(CreateUserCommand createUserCommand) {


        var userId = UserId.newId();
        var name = new Name(createUserCommand.firstName(), createUserCommand.middleName(), createUserCommand.lastName());
        var user = new User(userId, name);
        userRepository.save(user);


        return null;
    }
}
