package ru.stairenx.testappforsimaland.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

import ru.stairenx.testappforsimaland.R;
import ru.stairenx.testappforsimaland.databinding.CatalogCardBinding;
import ru.stairenx.testappforsimaland.view.model.CategoryModel;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.CardViewHolder> {

    private List<CategoryModel> data;
    private RecyclerViewListener listener;

    public CatalogAdapter(List<CategoryModel> data, RecyclerViewListener listener) {
        this.data = data;
        this.listener = listener;
    }

    public interface RecyclerViewListener{
        void onSelectedCategory(CategoryModel model);
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CatalogCardBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.catalog_card, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CardViewHolder extends ViewHolder{

        CatalogCardBinding binding;

        public CardViewHolder(CatalogCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CategoryModel model){
            binding.setModel(model);
            binding.card.setOnClickListener(v -> listener.onSelectedCategory(model));
        }
    }
}
