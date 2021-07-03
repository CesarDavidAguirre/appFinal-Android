package com.example.cesar.appfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Vector;

public class VerHistorial extends AppCompatActivity {
    public Alamacenar_Historial almacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_historial);
        almacen = new Alamacenar_Historial(this);
        Vector<String> datos = almacen.VerResultados(100);
        TextView Historial = (TextView) findViewById (R.id.textHistorial)  ;
        if (!datos.isEmpty()){
            Historial.append(datos.toString().replace(","," \n ").replace("["," ").replace("]"," "));
        }
    }
}
