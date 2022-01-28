package com.muharlyam.marketplace.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.muharlyam.marketplace.viewmodel.RegistrationViewModel;

public class RegistrationViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RegistrationViewModel();
    }
}