package com.oguzhan.wallet.api.controllers;


import com.oguzhan.wallet.api.requests.CreateUserRequest;
import com.oguzhan.wallet.application.usecase.PaginatedResults;
import com.oguzhan.wallet.application.usecase.user.createuser.CreateUserUseCase;
import com.oguzhan.wallet.application.usecase.user.createuser.UserDto;
import com.oguzhan.wallet.application.usecase.user.getusers.GetUsersQuery;
import com.oguzhan.wallet.application.usecase.user.getusers.GetUsersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUsersUseCase getUsersUseCase;


    public UserController(CreateUserUseCase createUserUseCase, GetUsersUseCase getUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }


    @GetMapping
    public ResponseEntity<PaginatedResults<UserDto>> getUsers(int page, int pageSize) {
        var result = getUsersUseCase.handle(new GetUsersQuery(page, pageSize));

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest req) {


        var dto = createUserUseCase.handle(req.toCommand());
        return ResponseEntity.ok(dto);
    }
}
