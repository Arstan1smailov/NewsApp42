
package com.company.newsapp41.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.company.models.News;
import com.company.newsapp41.R;
import com.company.newsapp41.databinding.FragmentHomeBinding;
import com.company.newsapp41.databinding.FragmentNewsBinding;
import com.company.newsapp41.ui.home.HomeFragment;
import com.company.newsapp41.ui.home.NewsAdapter;

import java.util.ArrayList;
import java.util.Locale;


public class NewsFragment extends Fragment {
    private FragmentNewsBinding binding;
    private NewsAdapter adapter;
    private News news;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new NewsAdapter();
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        news = (News) requireArguments().getSerializable("key1");
        if (news != null) {
            binding.editText.setText(news.getTitle());
            binding.btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    save();
                }
            });
        } else {
            binding.btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    save();
                }
            });
        }
    }


    private void save() {
        Bundle bundle = new Bundle();
        String text = binding.editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(requireContext(), "Title is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (news == null) {
            Log.e("TAG", "save: ");
            news = new News(text, System.currentTimeMillis());
        } else {
            Log.e("TAG", "save: 1111");
            news.setTitle(text);

        }
        bundle.putSerializable("news", news);
        getParentFragmentManager().setFragmentResult("rk_news", bundle);
        close();
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}