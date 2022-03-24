package com.company.newsapp41.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.interfaces.OnItemClickListener;
import com.company.models.News;
import com.company.newsapp41.R;
import com.company.newsapp41.databinding.ActivityMainBinding;
import com.company.newsapp41.databinding.ItemNewsBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    public ArrayList<News> list;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public NewsAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
        if (position % 2 == 0) {
            holder.binding.textTitle.setBackgroundColor(Color.GRAY);
            holder.binding.textTitle.setTextColor(Color.WHITE);
        } else {
            holder.binding.textTitle.setBackgroundColor(Color.BLUE);
            holder.binding.textTitle.setTextColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(News news) {
        list.add(0, news);
        notifyItemInserted(list.indexOf(news));
    }

    public News getItem(int position) {
        return list.get(position);
    }

    public void updateItem(News news, int position) {
        list.set(position, news);
        notifyItemChanged(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding binding;

        public ViewHolder(@NonNull ItemNewsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickListener.onItemLongClick(getAdapterPosition());
                    new AlertDialog.Builder(view.getContext()).setTitle("Delete")
                            .setMessage("are u sure?")
                            .setNegativeButton("No", null)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).show();
                    return true;
                }
            });
        }

        public void bind(News news) {
            binding.textTitle.setText(news.getTitle());
            Date res = new Date(news.getCreatedAt());
            SimpleDateFormat obj = new SimpleDateFormat("dd yyyy HH:mm", Locale.ROOT);
            String data = String.valueOf(obj.format(news.getCreatedAt()));
            binding.textTitle2.setText(data);
        }

    }
}
