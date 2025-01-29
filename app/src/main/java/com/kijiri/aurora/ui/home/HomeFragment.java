package com.kijiri.aurora.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kijiri.aurora.R;
import com.kijiri.aurora.adapter.TempResponseAdapter;
import com.kijiri.aurora.databinding.FragmentHomeBinding;
import com.kijiri.aurora.networkutils.HomeInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeService homeService;
    private RecyclerView recyclerView;
    private TempResponseAdapter tempResponseAdapter;
    private List<TempResponse> tempResponses;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tempResponseAdapter = new TempResponseAdapter(tempResponses);
        recyclerView.setAdapter(tempResponseAdapter);

        homeService = HomeInstance.initializeInstance().create(HomeService.class);

        fetchData();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void fetchData() {
        Call<List<TempResponse>> call = homeService.fetchPost();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<TempResponse>> call, Response<List<TempResponse>> response) {
                if (response.isSuccessful()) {
                    tempResponses.clear();
                    tempResponses.addAll(response.body());
                    tempResponseAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<TempResponse>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}