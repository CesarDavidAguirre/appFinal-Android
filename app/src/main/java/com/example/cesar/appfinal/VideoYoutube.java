package com.example.cesar.appfinal;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Ing.Cesar on 30/03/2017.
 */

public class VideoYoutube extends AppCompatActivity implements MediaPlayer.OnBufferingUpdateListener ,
        MediaPlayer.OnCompletionListener , MediaPlayer.OnPreparedListener, SurfaceHolder.Callback{

    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private static String videoUrl;
    // https://docs.google.com/uc?export=download&id=0ByJjdwTg7MnMX2cwR0NLME1fUzA
    // private static final String videoUrl = "http://personales.gan.upv.es/~jtomas/video.3gp";
    private TextView logTextView ;
    private int savePos = 0 ;
    private boolean pausa = false ;
    private Button play ,pause;
    public Alamacenar_Historial almacen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproducirvideo);
        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        PuntoProvide puntoProvide = new PuntoProvide();
        Fragment_1 fragment_1 = new Fragment_1();
        TextView titulo = (TextView) findViewById(R.id.titulo_server);
        TextView descrip = (TextView)findViewById(R.id.descri_server);
        ImageView imageView = (ImageView)findViewById(R.id.imagenserver);
        imageView.setImageResource(puntoProvide.imagenes(fragment_1.getPosicion_click()));
        titulo.setText(puntoProvide.GetTitulo(fragment_1.getPosicion_click()));
        descrip.setText(puntoProvide.GetDesc(fragment_1.getPosicion_click()));

        almacen = new Alamacenar_Historial(this);
        almacen.GuardarHistorial(" el Servidor",puntoProvide.GetTitulo(fragment_1.getPosicion_click()));

     //   logTextView = (TextView) findViewById(R.id.Logg);
        play = (Button) findViewById(R.id.buttonPlay);
        pause = (Button) findViewById(R.id.buttonPause);
    }
    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (mediaPlayer != null) {
            int pos = mediaPlayer.getCurrentPosition();
            savedInstanceState.putInt("pocision", pos);
        }
    }
    @Override
    protected void onRestoreInstanceState (Bundle restoreInstanceState) {
        super.onRestoreInstanceState(restoreInstanceState);
        if (restoreInstanceState != null){
            savePos =  restoreInstanceState.getInt("posicion");
        }
    }
    public void play (View view){

        play.setVisibility(View.INVISIBLE);

        pause.setVisibility(View.VISIBLE);

        try{
            if (pausa && mediaPlayer != null) {

            //    mediaPlayer.seekTo(savePos);
                mediaPlayer.start();

            }else {
                PuntoProvide puntoProvide = new PuntoProvide();
                Fragment_1 fragment_1 = new Fragment_1();
                videoUrl= puntoProvide.GetTrailerServer(fragment_1.getPosicion_click());
                pausa = false;
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(videoUrl);
                mediaPlayer.setDisplay(surfaceHolder);
                mediaPlayer.prepare();
                mediaPlayer.setOnBufferingUpdateListener(this);
                mediaPlayer.setOnCompletionListener(this);
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.seekTo(savePos);
            }
        } catch (Exception e){
            log("ERROR: " + e.getMessage());
        }
    }

    public void pause (View view){
        if (mediaPlayer != null){
            play.setVisibility(View.VISIBLE);
            pausa=true;
            mediaPlayer.pause();
            pause.setVisibility(View.INVISIBLE);

        }
    }
    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        log("onBafering....: " + i + "%");
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        log("onPrepare..: ");
        int mVideoWhit = mediaPlayer.getVideoWidth();
        int mVideoHid = mediaPlayer.getVideoHeight();
        if (mVideoHid != 0 && mVideoWhit != 0){
            surfaceHolder.setFixedSize(mVideoWhit,mVideoHid);
            mediaPlayer.start();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        log("surfaceCreate...: ");


    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    private void log(String s){

    }
    @Override
    public void onPause(){
        super.onPause();
        if(mediaPlayer!=null & !pausa){
            mediaPlayer.pause();
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        if(mediaPlayer!=null & !pausa){
            mediaPlayer.start();
        }
    }

}