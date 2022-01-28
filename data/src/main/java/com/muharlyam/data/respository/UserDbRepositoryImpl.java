package com.muharlyam.data.respository;

import com.muharlyam.domain.model.rest.CreateUserResponse;
import com.muharlyam.domain.model.wrappers.GeneralResult;
import com.muharlyam.domain.repository.UserDbRepository;

public class UserDbRepositoryImpl implements UserDbRepository {
    @Override
    public GeneralResult saveUserAfterSignIn(CreateUserResponse createUserResponse) {
        return null;
    }
}
