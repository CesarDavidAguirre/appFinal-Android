package com.example.cesar.appfinal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ing.Cesar on 01/04/2017.
 */

public class PuntosAdapter extends BaseAdapter {
    private final Activity actividad;
    private final String [] lista;
    private final String [] descri;

    public PuntosAdapter (Activity actividad, String[] lista,String [] descri ){
        super();
        this.actividad =actividad;
        this.lista= lista;
        this.descri=descri;

    }

    @Override
    public int getCount() {
        return this.lista.length;
    }

    @Override
    public Object getItem(int pocicion) {
        return this.lista[pocicion];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view2 = inflater.inflate(R.layout.elemento_lista,null,true);
        TextView textView = (TextView) view2.findViewById(R.id.titular);
        TextView textView2 = (TextView) view2.findViewById(R.id.pie_descrip);
        textView.setText(this.lista[position]);
        textView2.setText(this.descri[position]);

        // ImageView imageView = (ImageView) view.findViewById(R.id.icono);
        // imageView.setImageResource();
        return view2;


    }
}
