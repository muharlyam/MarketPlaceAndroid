package com.muharlyam.domain.business;

import com.muharlyam.domain.model.rest.CreateUserResponse;
import com.muharlyam.domain.model.wrappers.GeneralResult;
import com.muharlyam.domain.model.wrappers.NetworkResult;
import com.muharlyam.domain.model.wrappers.Result;
import com.muharlyam.domain.repository.UserDbRepository;
import com.muharlyam.domain.repository.UserNetworkRepository;

public class UserDataHandler {

    private final UserDbRepository userDbRepository;
    private final UserNetworkRepository userNetworkRepository;

    public UserDataHandler(UserDbRepository userDbRepository, UserNetworkRepository userNetworkRepository) {
        this.userDbRepository = userDbRepository;
        this.userNetworkRepository = userNetworkRepository;
    }

    public Result<CreateUserResponse> createUser(String idToken, String email) {
        Result<CreateUserResponse> result = new Result<>();

        NetworkResult<CreateUserResponse> networkResult = userNetworkRepository.createUser(idToken, email);
        if (!networkResult.isSuccessful()) {
            result.setException(networkResult.getException());
            return result;
        }

        CreateUserResponse createUserResponse = networkResult.getResult();
        GeneralResult dbResult = userDbRepository.saveUserAfterSignIn(createUserResponse);
        if (!dbResult.isSuccessful()) {
            result.setException(dbResult.getException());
            return result;
        }

        result.setResult(createUserResponse);
        return result;
    }

}