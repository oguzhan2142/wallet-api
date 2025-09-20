package com.oguzhan.wallet.application.usecase.user.getusers;

import com.oguzhan.wallet.application.usecase.PaginatedResults;
import com.oguzhan.wallet.application.usecase.UseCase;
import com.oguzhan.wallet.application.usecase.user.createuser.UserDto;
import com.oguzhan.wallet.domain.user.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GetUsersUseCase implements UseCase<GetUsersQuery, PaginatedResults<UserDto>> {


    private final UserRepository userRepository;

    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PaginatedResults<UserDto> handle(GetUsersQuery getUsersQuery) {
        var page = userRepository.findAll(PageRequest.of(getUsersQuery.page(), getUsersQuery.pageSize()));

        var items = page.getContent()
                .stream()
                .map(UserDto::fromUserEntity)
                .toList();

        return new PaginatedResults<UserDto>(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements(), items);
    }
}
