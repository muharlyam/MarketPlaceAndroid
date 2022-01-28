package com.muharlyam.marketplace.viewmodel;

import androidx.lifecycle.ViewModel;

import com.muharlyam.marketplace.MarketPlaceApplication;

public class RegistrationViewModel extends ViewModel {

    public RegistrationViewModel() {
        super();
    }

    public void createUser (String idToken, String email) {
        MarketPlaceApplication.getExecutorService()
                .execute(() -> {

                });
    }
}
