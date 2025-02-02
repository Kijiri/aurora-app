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
import com.kijiri.aurora.databinding.FragmentCreateAccountBinding;

public class CreateAccountFragment extends Fragment {
    private FragmentCreateAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView alreadyHaveAccountLink = root.findViewById(R.id.alreadyHaveAccountLink);
        EditText emailInput = root.findViewById(R.id.crateEmail);
        EditText passwordInput = root.findViewById(R.id.createPassword);
        EditText passwordVerificationInput = root.findViewById(R.id.createPasswordVerification);
        Button signUpButton = root.findViewById(R.id.signUpButton);

        alreadyHaveAccountLink.setOnClickListener(view -> {
            NavHostFragment.findNavController(CreateAccountFragment.this)
                    .navigate(R.id.action_createAccountFragment_to_loginFragment);
        });

        signUpButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String passwordVerification = passwordVerificationInput.getText().toString();

            Log.d(
                    "CreateAccountFragment",
                "Sign up button clicked with email: " + email + " and password: " + password
            );

            // TODO: Validate email and password
            // TODO: Create user with email and password
        });



        return root;
    }

}
