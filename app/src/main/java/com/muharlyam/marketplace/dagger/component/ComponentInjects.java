package com.muharlyam.marketplace.dagger.component;

import com.muharlyam.marketplace.MarketPlaceApplication;
import com.muharlyam.marketplace.ui.intro.IntroActivity;
import com.muharlyam.marketplace.ui.intro.SignUpFragment;
import com.muharlyam.marketplace.ui.intro.SplashFragment;

interface ComponentInjects {

    void inject(MarketPlaceApplication walkingDatingApplication);

    void inject(SignUpFragment signUpFragment);

    void inject(IntroActivity introActivity);

    void inject(SplashFragment splashFragment);
}
