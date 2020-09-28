package com.example.appifba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.appifba.R;
import com.example.appifba.model.Denuncia;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adapter extends FirebaseRecyclerAdapter<Denuncia, DenunciaViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter(@NonNull FirebaseRecyclerOptions<Denuncia> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DenunciaViewHolder holder, int position, @NonNull Denuncia model) {
        holder.setDenucia(model.getDescricao());

    }

    @NonNull
    @Override
    public DenunciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_recicler, parent, false);
        return new DenunciaViewHolder(view);
    }


}
