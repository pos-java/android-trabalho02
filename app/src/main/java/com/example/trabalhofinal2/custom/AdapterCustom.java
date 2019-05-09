package com.example.trabalhofinal2.custom;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabalhofinal2.model.Ponto;
import com.example.trabalhofinal2.R;

import java.util.List;

public class AdapterCustom extends BaseAdapter {
    private final List<Ponto> pontos;
    private final Activity act;

    public AdapterCustom(List<Ponto> pontos, Activity act) {
        this.pontos = pontos;
        this.act = act;
    }


    @Override
    public int getCount() {
        return this.pontos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.pontos.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = act.getLayoutInflater().inflate(R.layout.activity_list_custom, viewGroup, false);

        //pegando as referências das Views
        TextView nome = (TextView) view.findViewById(R.id.tvNome);
        TextView endereco = (TextView) view.findViewById(R.id.tvEndereco);
        ImageView imagem = (ImageView) view.findViewById(R.id.ivImagem);

        Ponto ponto = this.pontos.get(position);

        Bitmap bitmapImage = BitmapFactory.decodeByteArray(ponto.getImage(), 0, ponto.getImage().length);

        nome.setText(ponto.getNome());
        endereco.setText(ponto.getEndereco());
        imagem.setImageBitmap(bitmapImage);

        return view;
    }
}
