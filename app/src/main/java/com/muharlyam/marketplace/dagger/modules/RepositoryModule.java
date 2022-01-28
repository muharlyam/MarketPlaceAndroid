package com.muharlyam.marketplace.dagger.modules;

import com.muharlyam.data.respository.UserDbRepositoryImpl;
import com.muharlyam.data.respository.UserNetworkRepositoryImpl;
import com.muharlyam.domain.repository.UserDbRepository;
import com.muharlyam.domain.repository.UserNetworkRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    UserNetworkRepository provideUserNetworkRepository() {
        return new UserNetworkRepositoryImpl();
    }

    @Provides
    @Singleton
    UserDbRepository provideUserDbRepository() {
        return new UserDbRepositoryImpl();
    }


    public interface Exposes {

        UserNetworkRepository getUserNetworkRepository();

        UserDbRepository getUserDbRepository();

    }

}
