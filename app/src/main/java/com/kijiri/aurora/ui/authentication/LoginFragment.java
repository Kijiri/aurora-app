package com.kijiri.aurora.ui.authentication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.kijiri.aurora.R;
import com.kijiri.aurora.databinding.FragmentLoginBinding;
import com.kijiri.aurora.service.AuthClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView createAccountLink = root.findViewById(R.id.crateAccountLink);
        EditText emailInput = root.findViewById(R.id.loginEmail);
        EditText passwordInput = root.findViewById(R.id.loginPassword);
        Button signInButton = root.findViewById(R.id.signInButton);

        createAccountLink.setOnClickListener(view -> {
            Log.d("LoginFragment", "Create account link clicked");
            NavHostFragment.findNavController(LoginFragment.this)
                    .navigate(R.id.action_loginFragment_to_createAccountFragment);
        });

        // TODO: Authenticate user with email and password
        signInButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            Call<AuthenticationResponse> login = AuthClient.getInstance().getApiService().login(new LoginUser(email, password));
            login.enqueue(new Callback<AuthenticationResponse>() {
                @Override
                public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                    Log.i("LoginFragment", "Auth response: " + response.body().getMessage());
                    Log.i("LoginFragment", "Auth access token: " + response.body().getAccessToken());
                    Log.i("LoginFragment", "Auth refresh token: " + response.body().getRefreshToken());
                }

                @Override
                public void onFailure(Call<AuthenticationResponse> call, Throwable t) {

                }
            });
            Log.d(
                    "LoginFragment",
                    "Sign in button clicked with email: " + email + " and password: " + password
            );

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
