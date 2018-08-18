package com.example.aula_01.recyclefatima;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import java.util.List;

public class FatimaAdapter extends RecyclerView.Adapter<FatimaAdapter.ViewHolder> {

    List<MinasProgramacao> list;
    Context context;
    Click_Listener clickListener;

    public FatimaAdapter(List<MinasProgramacao> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FatimaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflate.inflate(R.layout.layout_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FatimaAdapter.ViewHolder holder, int position) {
        MinasProgramacao minasProgramacao = list.get(position);
       holder.bind(minasProgramacao.getNome(), minasProgramacao.getImagem());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // aqui se encerra a classe FatimaAdapter e abaixo inicia a classe viewHolder, porque viewHolder trabalha junto com adapter
    // neste caso, por trabalharem juntas, podemos ter "classe dentro de classe"


    public void setClickListener(Click_Listener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nome;
        ImageView imagem;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.nome = itemView.findViewById(R.id.textodaimagem);
            this.imagem = itemView.findViewById(R.id.imagem);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        public int getImageDrawableResId(String imageId ){
            Resources resources = context.getResources();
            return resources.getIdentifier(imageId, "drawable", context.getPackageName());
        }

        public void bind(String nome, String imagem){
            this.nome.setText(nome);
            this.imagem.setImageResource(getImageDrawableResId(imagem));
        }

        @Override
        public void onClick(View view){
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
