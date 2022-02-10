package com.polho.sailorplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class musicList extends AppCompatActivity {

    private ListView Listviewww;
    private ArrayList<String> ListViewTAG_names_music;
    private ArrayAdapter adapter_tag_list_music;
    private ImageButton return_toPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);




        Listviewww = findViewById(R.id.ListVieww);

        ListViewTAG_names_music = new ArrayList<String>();
        ListViewTAG_names_music.add(0,"0 - Don Toliver - After Party");
        ListViewTAG_names_music.add(1,"1 - Daft Punk - Around the World");
        ListViewTAG_names_music.add(2,"2 - Karri - Rosetta");
        ListViewTAG_names_music.add(3,"3 - MGMT - Little Dark Age");
        ListViewTAG_names_music.add(4,"4 - Daft Punk - Harder Better Faster");
        ListViewTAG_names_music.add(5,"5 - Notorious Big - Big Poppa");

        adapter_tag_list_music = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListViewTAG_names_music);
        Listviewww.setAdapter(adapter_tag_list_music);









    }

    public void goto_musiclist2(View v){
        Intent intent_music_list2 = new Intent(this, MainActivity.class);
        startActivity(intent_music_list2);
    }




















}