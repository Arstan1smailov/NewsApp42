package com.company.newsapp41.ui.Border;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.company.Prefs;
import com.company.newsapp41.R;
import com.company.newsapp41.databinding.FragmentBoardBinding;
import com.company.newsapp41.databinding.FragmentNewsBinding;

public class BoardFragment extends Fragment {
    private FragmentBoardBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BoardAdapter adapter = new BoardAdapter();
        binding.ViewPager.setAdapter(adapter);
        BoardAdapter boardAdapter = new BoardAdapter();
        binding.ViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2){
                  binding.btnSkip2.setVisibility(View.INVISIBLE);
                }else
                {
                    binding.btnSkip2.setVisibility(View.VISIBLE);

                }
            }
        });
        binding.btnSkip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
            }
        });
    }

    private void close() {
        Prefs prefs = new Prefs(requireContext());
        prefs.saveBoardState();
        NavController navController = Navigation.findNavController((Activity) requireContext(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}