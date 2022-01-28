package com.muharlyam.domain.repository;

import com.muharlyam.domain.model.rest.CreateUserResponse;
import com.muharlyam.domain.model.wrappers.NetworkResult;

public interface UserNetworkRepository {

    NetworkResult<CreateUserResponse> createUser(String idToken, String email);

}
