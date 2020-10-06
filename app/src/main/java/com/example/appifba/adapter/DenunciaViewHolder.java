package com.example.appifba.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.appifba.R;
import com.example.appifba.model.Denuncia;

public class DenunciaViewHolder  extends ViewHolder {
    private View view;
    private Iclick iclick;

    public DenunciaViewHolder setIclick(Iclick iclick) {
        this.iclick = iclick;
        return null;
    }


    private Denuncia denuncia;
    public DenunciaViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.view = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {

                      @Override
                      public void onClick(View view) {
                            iclick.click(denuncia);
                      }
        }

        );
    }


    public  void  setDenucia(Denuncia denucia)
    {
        this.denuncia = denucia;
        TextView edenucia = (TextView) view.findViewById(R.id.text_view_id_item);
        edenucia.setText(denucia.getDescricao());
    }

    public interface Iclick
    {
        public void click(Denuncia denuncia);
    }
}
