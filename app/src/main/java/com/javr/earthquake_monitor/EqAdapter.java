package com.javr.earthquake_monitor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eq_list_item, parent, false);
        return new EqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EqAdapter.EqViewHolder holder, int position) {
        Earthquake earthquake = getItem(position);

        holder.bind(earthquake);
    }

    class EqViewHolder extends RecyclerView.ViewHolder{
    private TextView magnitudeText;
    private TextView placeText;

        public EqViewHolder(@NonNull View itemView) {
            super(itemView);

            magnitudeText = itemView.findViewById(R.id.txtMagnitude);
            placeText = itemView.findViewById(R.id.txtPlace);

        }

        public void bind(Earthquake earthquake){
            magnitudeText.setText(String.valueOf(earthquake.getMagnitude()));
            placeText.setText(earthquake.getPlace());

        }
    }
}
