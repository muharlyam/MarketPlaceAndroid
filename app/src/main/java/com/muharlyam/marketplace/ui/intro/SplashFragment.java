package com.muharlyam.marketplace.ui.intro;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.muharlyam.marketplace.MarketPlaceApplication;
import com.muharlyam.marketplace.R;
import com.muharlyam.marketplace.viewmodel.RegistrationViewModel;

public class SplashFragment extends Fragment {

    private NavController navController;
    private FirebaseAuth firebaseAuth;

    private RegistrationViewModel registrationViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MarketPlaceApplication.getApplicationComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_splash, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        registrationViewModel = ViewModelProviders.of(requireActivity()).get(RegistrationViewModel.class);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null)
            startApplication(currentUser);
        else
            openSignUpPage();
    }

    private void startApplication(FirebaseUser currentUser) {
        updateIdToken(currentUser);
        Bundle bundle = new Bundle();
        navController.navigate(R.id.action_splashFragment_to_mainActivity2, bundle);
    }

    private void openSignUpPage() {
        navController.navigate(R.id.action_splashFragment_to_signUpFragment);
    }

    private void updateIdToken(FirebaseUser currentUser) {
        Task<GetTokenResult> task = currentUser.getIdToken(true);
        task.addOnSuccessListener(getTokenResult -> {
            System.out.println(getTokenResult.getToken());

            // todo update via ViewModel
        });
    }

}