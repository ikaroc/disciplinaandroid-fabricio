package com.polho.sailorplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer player;
    private SeekBar seekbar;
    private ImageButton botao_play;
    private ImageButton ir_lista_musicas;
    public ArrayList Lista;
    private int current_music;
    private int index_music = 0;
    private ImageButton button_next;
    private ImageButton button_prev;
    public ArrayList<String> Lista_names_music;
    private TextView txt_song_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lista = new ArrayList();
        Lista.add(0,R.raw.after_party);
        Lista.add(1,R.raw.around_the_world_);
        Lista.add(2,R.raw.karri_rosetta);
        Lista.add(3,R.raw.lil_dark_age);
        Lista.add(4,R.raw.harder_better_faster_);
        Lista.add(5,R.raw.bigpoppa_);

        Lista_names_music = new ArrayList<String>();
        Lista_names_music.add(0,"Don Toliver - After Party");
        Lista_names_music.add(1,"Daft Punk - Around the World");
        Lista_names_music.add(2,"Karri - Rosetta");
        Lista_names_music.add(3,"MGMT - Little Dark Age");
        Lista_names_music.add(4,"Daft Punk - Harder Better Faster");
        Lista_names_music.add(5,"Notorious Big - Big Poppa");

        txt_song_name = findViewById(R.id.song_names);
        txt_song_name.setText(Lista_names_music.get(0));





        current_music = (int) Lista.get(index_music);

        player = MediaPlayer.create(MainActivity.this, current_music);

        botao_play = findViewById(R.id.Play_Pause);

        seekbar = findViewById(R.id.seekBar);
        seekbar.setMax(player.getDuration());

        button_next = findViewById(R.id.next_buttom);
        button_prev = findViewById(R.id.prev_buttom);





        //////

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekbar.setProgress(player.getCurrentPosition());

            }
        }, 0,900);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                player.seekTo(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });







    }
    ///////////


    //PLAYER
    public void play(View view) {
        if (player.isPlaying()) {
            player.pause();
            botao_play.setImageResource(R.drawable.play_button_music);

        } else {
            player.start();
            botao_play.setImageResource(R.drawable.ic_baseline_pause_24);
        }
    }

    public void stop(View view) {
        if (player.isPlaying()) {
            player.stop();
            botao_play.setImageResource(R.drawable.play_button_music);
            player = MediaPlayer.create(MainActivity.this, current_music);
        }else{
            player.stop();
            botao_play.setImageResource(R.drawable.play_button_music);
            player = MediaPlayer.create(MainActivity.this, current_music);

        }
    }

    public void goto_musiclist(View v){
        Intent intent_music_list = new Intent(MainActivity.this, musicList.class);
        startActivity(intent_music_list);
        Toast.makeText(getApplicationContext(),"Lista de músicas", Toast.LENGTH_SHORT).show();
    }

    public void next_music(View v){
        index_music++;
        if (index_music > 5){
            index_music = 0;

        }
        current_music = (int) Lista.get(index_music);


        player.stop();
        player = MediaPlayer.create(MainActivity.this, current_music);
        txt_song_name.setText(Lista_names_music.get(index_music));
        player.start();
        botao_play.setImageResource(R.drawable.ic_baseline_pause_24);

    }



    public void prev_music(View v){
        index_music--;
        if (index_music < 0){
            index_music = 5;

        }
        current_music = (int) Lista.get(index_music);

        player.stop();
        player = MediaPlayer.create(MainActivity.this, current_music);
        txt_song_name.setText(Lista_names_music.get(index_music));
        player.start();
        botao_play.setImageResource(R.drawable.ic_baseline_pause_24);

    }




















///////
}


