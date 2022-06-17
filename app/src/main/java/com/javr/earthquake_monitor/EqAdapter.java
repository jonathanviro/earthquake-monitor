package com.javr.earthquake_monitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.javr.earthquake_monitor.databinding.EqListItemBinding;

public class EqAdapter extends ListAdapter<Earthquake, EqAdapter.EqViewHolder> {

    public static final DiffUtil.ItemCallback<Earthquake> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Earthquake>() {
                @Override
                public boolean areItemsTheSame(@NonNull Earthquake oldItem, @NonNull Earthquake newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Earthquake oldItem, @NonNull Earthquake newItem) {
                    return oldItem.equals(newItem);
                }
            };


    protected EqAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public EqAdapter.EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //CAMBIANDO A BINDING
        EqListItemBinding binding = EqListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new EqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EqAdapter.EqViewHolder holder, int position) {
        Earthquake earthquake = getItem(position);

        holder.bind(earthquake);
    }

    class EqViewHolder extends RecyclerView.ViewHolder{
        //CAMBIANDO A BINDING
        private EqListItemBinding binding;

        public EqViewHolder(@NonNull EqListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(Earthquake earthquake){
            binding.txtMagnitude.setText(String.valueOf(earthquake.getMagnitude()));
            binding.txtPlace.setText(earthquake.getPlace());

            binding.executePendingBindings();
        }
    }
}
