package com.oguzhan.wallet.application.usecase;


import com.oguzhan.wallet.application.usecase.user.createuser.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public record PaginatedResults<T>(int page, int pageSize, int totalPages, long totalItems, List<T> items) {





}
