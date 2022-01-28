package com.muharlyam.marketplace.dagger.modules;

import com.muharlyam.domain.business.UserDataHandler;
import com.muharlyam.domain.repository.UserDbRepository;
import com.muharlyam.domain.repository.UserNetworkRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProcessorsModule {

    @Provides
    @Singleton
    UserDataHandler provideUserDataHandler(UserDbRepository userDbRepository, UserNetworkRepository userNetworkRepository) {
        return new UserDataHandler(userDbRepository, userNetworkRepository);
    }

    public interface Exposes {

        UserDataHandler getUserDataHandler();

    }

}
