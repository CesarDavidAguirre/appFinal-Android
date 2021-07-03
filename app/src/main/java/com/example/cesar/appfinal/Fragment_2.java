package com.example.cesar.appfinal;

import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_2 extends Fragment {
   private LocationManager manejador;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState ){
        return inflater.inflate(R.layout.activity_fragment_2, container, false);
    }

}
