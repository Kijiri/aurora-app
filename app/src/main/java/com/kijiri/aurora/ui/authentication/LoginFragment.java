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

import com.kijiri.aurora.R;
import com.kijiri.aurora.databinding.FragmentLoginBinding;

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
            // TODO: Navigate to create account fragment
            Log.d("LoginFragment", "Create account link clicked");
        });

        signInButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            // TODO: Authenticate user with email and password
            Log.d(
                    "LoginFragment",
                "Sign in button clicked with email: " + email + " and password: " + password
            );

        });

        return root;
    }
}
