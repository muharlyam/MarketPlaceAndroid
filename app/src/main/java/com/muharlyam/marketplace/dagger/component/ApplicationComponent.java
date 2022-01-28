package com.muharlyam.marketplace.dagger.component;

import com.muharlyam.marketplace.dagger.modules.ProcessorsModule;
import com.muharlyam.marketplace.dagger.modules.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                RepositoryModule.class,
                ProcessorsModule.class
        }
)
public interface ApplicationComponent extends ComponentExposes, ComponentInjects {

    final class Initializer {
        static public ApplicationComponent init() {
            return DaggerApplicationComponent.builder()
                    .repositoryModule(new RepositoryModule())
                    .processorsModule(new ProcessorsModule())
                    .build();
        }
    }

}
