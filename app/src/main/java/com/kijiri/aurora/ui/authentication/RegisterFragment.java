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
import com.kijiri.aurora.databinding.FragmentRegisterBinding;
import com.kijiri.aurora.service.AuthClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView alreadyHaveAccountLink = root.findViewById(R.id.alreadyHaveAccountLink);

        EditText firstNameInput = root.findViewById(R.id.createFirstName);
        EditText lastNameInput = root.findViewById(R.id.createLastName);
        EditText usernameInput = root.findViewById(R.id.createUsername);
        EditText emailInput = root.findViewById(R.id.createEmail);
        EditText passwordInput = root.findViewById(R.id.createPassword);
        EditText passwordVerificationInput = root.findViewById(R.id.createPasswordVerification);
        Button signUpButton = root.findViewById(R.id.signUpButton);

        alreadyHaveAccountLink.setOnClickListener(view -> {
            NavHostFragment.findNavController(RegisterFragment.this)
                    .navigate(R.id.action_createAccountFragment_to_loginFragment);
        });

        //TODO validate email and password
        signUpButton.setOnClickListener(view -> {
            String firstName = firstNameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String username = usernameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String passwordVerification = passwordVerificationInput.getText().toString();


            if (passwordVerification.equals(password)) {
                Log.i("CreateAccountFragment", "register");
                Call<String> register = AuthClient.getInstance().getApiService().register(new RegisterUser(firstName, lastName, username, email, password));
                register.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                        if (response.code() >= 400) {
                            Log.e("CreateAccountFragment", "register failed with error code: " + response.code());
                            try {
                                Log.e("CreateAccountFragment", "onResponse: " + response.errorBody().string());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        else if (response.code() == 202) {
                            Log.i("CreateAccountFragment", "register successful");
                            NavHostFragment.findNavController(RegisterFragment.this)
                                    .navigate(R.id.action_createAccountFragment_to_loginFragment);
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("CreateAccountFragment", "register failed");
                    }
                });
            }

            Log.i(
                    "CreateAccountFragment",
                    "Sign up button clicked with email: " + email + " and password: " + password
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
