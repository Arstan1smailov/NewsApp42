package com.company.newsapp41.ui.Border;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.company.models.Board;
import com.company.newsapp41.R;
import com.company.newsapp41.databinding.PagerBoardBinding;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    public ArrayList<Board> list;
    public boolean A = false;

    public BoardAdapter() {
        list = new ArrayList<>();
        list.add(new Board("Общайся со своими знакомыми", "", R.drawable.photo2));
        list.add(new Board("Находи новых друзей", "", R.drawable.photo2));
        list.add(new Board("Устраивай деловые звонки", "", R.drawable.photo2));

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public int position;
        private Button btnStart;
        private ImageView boardPhoto;
        private TextView textDesc;

        private PagerBoardBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = PagerBoardBinding.bind(itemView);
            textView = itemView.findViewById(R.id.TextTheme);
            btnStart = itemView.findViewById(R.id.btnStart);
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).popBackStack();
                }
            });
        }

        public void bind(int position) {

//            textDesc = itemView.findViewById(R.id.TextTheme);
//            textView = itemView.findViewById(R.id.btnSkip2);
//            boardPhoto = itemView.findViewById(R.id.image);

            Board board = list.get(position);
            binding.image.setImageResource(board.getImage());
            binding.TextTheme.setText(board.getTitle());

            if (position == list.size() - 1) {
                binding.btnStart.setVisibility(View.VISIBLE);
            } else {
                btnStart.setVisibility(View.INVISIBLE);
            }
        }
    }
}
