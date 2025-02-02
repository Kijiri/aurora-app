package com.kijiri.aurora.ui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        alreadyHaveAccountLink.setOnClickListener(view -> {
            NavHostFragment.findNavController(CreateAccountFragment.this)
                    .navigate(R.id.action_createAccountFragment_to_loginFragment);
        });


        return root;
    }

}
