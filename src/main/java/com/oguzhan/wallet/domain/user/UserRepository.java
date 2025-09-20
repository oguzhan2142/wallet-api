package com.oguzhan.wallet.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    public User save(User user);


    Page<User> findAll(Pageable pageable);
}
