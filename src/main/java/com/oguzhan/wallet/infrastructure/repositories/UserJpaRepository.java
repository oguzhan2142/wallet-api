package com.oguzhan.wallet.infrastructure.repositories;

import com.oguzhan.wallet.domain.user.User;
import com.oguzhan.wallet.domain.user.UserId;
import com.oguzhan.wallet.domain.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, UserId>, UserRepository {


}
