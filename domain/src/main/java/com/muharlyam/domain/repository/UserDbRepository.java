package com.muharlyam.domain.repository;

import com.muharlyam.domain.model.rest.CreateUserResponse;
import com.muharlyam.domain.model.wrappers.GeneralResult;

public interface UserDbRepository {

    public GeneralResult saveUserAfterSignIn(CreateUserResponse createUserResponse);

}
