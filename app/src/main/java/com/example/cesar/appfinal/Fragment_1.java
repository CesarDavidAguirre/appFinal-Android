package com.example.cesar.appfinal;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.IOException;
import java.util.zip.Inflater;

public class Fragment_1 extends Fragment implements AdapterView.OnItemClickListener{

    public static int posicion_click =0;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState ){
        //return inflater.inflate(R.layout.tab_fragment_1, container, false);
        View rootView = inflater.inflate(R.layout.activity_fragment_1,container,false);
        ListView listView = (ListView) rootView.findViewById(R.id.ListView);

        listView.setAdapter(new PuntosAdapter(getActivity(),PuntoProvide.GetPlanetas(),PuntoProvide.Descripcion()));
        listView.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(getActivity(), "preciones la telca =" + position,Toast.LENGTH_SHORT).show()
              posicion_click = position;
              Intent intent = new Intent(getActivity(),select.class);
              startActivity(intent);
          }

    public int getPosicion_click (){
        return posicion_click;
    }

    }







