package demo.com.sorted;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewholder>{

    private ArrayList<Integer> models;

    public RvAdapter(ArrayList<Integer> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public RvViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_item, parent,false);
        return new RvViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewholder holder, int position) {
        Integer model = models.get(position);
        holder.textViewNumber.setText("" + model);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    class RvViewholder extends RecyclerView.ViewHolder{

        private TextView textViewNumber;

        public RvViewholder(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);

        }
    }
}
