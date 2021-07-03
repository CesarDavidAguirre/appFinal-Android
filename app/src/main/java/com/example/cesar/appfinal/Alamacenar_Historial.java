package com.example.cesar.appfinal;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


/**
 * Created by Ing.Cesar on 14/04/2017.
 */

public class Alamacenar_Historial  {
    private static String historial = "historial";
    private Context context;

    public Alamacenar_Historial (Context context){
        this.context=context;

    }
    public void GuardarHistorial(String nombre , String Titulo){
        try {
            FileOutputStream f = context.openFileOutput(historial, Context.MODE_APPEND);
            String Texto = ("Por :" + nombre + " Viste: " + Titulo + "\r\n") ;
            f.write(Texto.getBytes());
            f.close();

        }
        catch (IOException e){
            Log.e("ERROR",e.getMessage(),e);

        }
    }
    public Vector<String> VerResultados (int cantidad) {
        Vector<String> result = new Vector<String>();
        try {
            FileInputStream file = context.openFileInput(historial);
            BufferedReader entreda = new BufferedReader(new InputStreamReader(file));
            int i = 0;
            String linea;
            do {
                linea=entreda.readLine();
                if (linea!=null){
                    result.add(linea);
                    i++;
                }
            } while (i<cantidad && linea != null);
            file.close();

        }
        catch (IOException e){
            Log.e("ERROR", e.getMessage(),e);
        }
    return result;
    }

}
