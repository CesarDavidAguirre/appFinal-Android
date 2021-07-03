package com.example.cesar.appfinal;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class probando extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static String VIDEO_ID ;
    private static final String API_KEY = "AIzaSyAS3HV6gKCM2hPh2Y0aD1nibK2nXmNKxQ8" ;
    public Alamacenar_Historial almacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        Fragment_1 fragment = new Fragment_1();
        PuntoProvide puntoProvide = new PuntoProvide();
        VIDEO_ID= puntoProvide.GetTrailer(fragment.getPosicion_click());

        TextView titulo= (TextView) findViewById(R.id.titulo);
        titulo.setText(puntoProvide.GetTitulo(fragment.getPosicion_click()));

        TextView descripcion= (TextView) findViewById((R.id.descri));
        descripcion.setText(puntoProvide.GetDesc(fragment.getPosicion_click()));

        ImageView imageView = (ImageView) findViewById(R.id.imagenyoutube);
        imageView.setImageResource(puntoProvide.imagenes(fragment.getPosicion_click()));

        almacen = new Alamacenar_Historial(this);
        almacen.GuardarHistorial("Youtube" ,puntoProvide.GetTitulo(fragment.getPosicion_click()));

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if (!b){
            youTubePlayer.cueVideo(VIDEO_ID);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "fallo inicializacion ",Toast.LENGTH_LONG).show();
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener(){
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
