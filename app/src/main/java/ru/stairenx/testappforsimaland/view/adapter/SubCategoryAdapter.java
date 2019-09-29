package ru.stairenx.testappforsimaland.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

import ru.stairenx.testappforsimaland.R;
import ru.stairenx.testappforsimaland.databinding.SubcategoryCardBinding;
import ru.stairenx.testappforsimaland.view.model.CategoryModel;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryHolder> {

    private List<CategoryModel> data;

    public SubCategoryAdapter(List<CategoryModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public SubCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SubcategoryCardBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.subcategory_card, parent, false);
        return new SubCategoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SubCategoryHolder extends ViewHolder{

        SubcategoryCardBinding binding;

        public SubCategoryHolder(SubcategoryCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CategoryModel model){
            binding.setModel(model);
        }
    }
}
