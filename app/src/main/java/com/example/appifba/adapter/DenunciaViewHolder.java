package com.example.appifba.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.appifba.R;

public class DenunciaViewHolder  extends ViewHolder {
    private View view;

    public DenunciaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
    }


    public  void  setDenucia(String denucia)
    {
        TextView edenucia = (TextView) view.findViewById(R.id.text_view_id_item);
        edenucia.setText(denucia);
    }


}
