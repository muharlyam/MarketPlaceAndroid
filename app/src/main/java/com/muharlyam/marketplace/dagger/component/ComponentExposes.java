package com.muharlyam.marketplace.dagger.component;

import com.muharlyam.marketplace.dagger.modules.ProcessorsModule;
import com.muharlyam.marketplace.dagger.modules.RepositoryModule;

interface ComponentExposes extends RepositoryModule.Exposes, ProcessorsModule.Exposes {
}