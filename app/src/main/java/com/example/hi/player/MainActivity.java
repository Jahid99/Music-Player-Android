package com.example.hi.player;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    MediaPlayer mPlayer;
    ImageButton buttonPlay;
    ImageButton buttonStop;
    ImageButton buttonNext;
    ImageButton buttonPrev;
    boolean isPaused;
    int position;
    int currentAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.play);
        buttonStop = findViewById(R.id.pause);
        buttonNext = findViewById(R.id.left);
        buttonPrev = findViewById(R.id.right);
        currentAudio = 1;



        buttonPlay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                switch (currentAudio){

                    case 1:
                        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell1);
                        break;
                    case 2:
                        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell2);
                        break;
                    case 3:
                        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell3);
                        break;
                    case 4:
                        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell4);
                        break;
                    case 5:
                        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell5);
                        break;
                    case 6:
                        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell6);
                        break;

                }

               // mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell1);

                if(isPaused){
                    mPlayer.start();
                    mPlayer.seekTo(position);
                }

                try {
                    mPlayer.start();
                } catch (Exception e) {

                }

                buttonPlay.setVisibility(View.INVISIBLE);
                buttonStop.setVisibility(View.VISIBLE);

            }
        });


        buttonStop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                currentAudio = 1;

               if(mPlayer!=null && mPlayer.isPlaying()){
                   //mPlayer.stop();
                   mPlayer.pause();
                   position = mPlayer.getCurrentPosition();
                   isPaused=true;
                   buttonPlay.setVisibility(View.VISIBLE);
                   buttonStop.setVisibility(View.INVISIBLE);
               }


                if(currentAudio<1) currentAudio=6;


            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                currentAudio += 1;

                if(mPlayer!=null){
                    mPlayer.stop();
                    mPlayer.release();
                    buttonPlay.setVisibility(View.VISIBLE);
                    buttonStop.setVisibility(View.INVISIBLE);
                }


                if(currentAudio>6) currentAudio=1;


            }
        });

        buttonPrev.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                currentAudio -= 1;

                if(mPlayer!=null){
                    mPlayer.stop();
                    mPlayer.release();
                    buttonPlay.setVisibility(View.VISIBLE);
                    buttonStop.setVisibility(View.INVISIBLE);
                }


                if(currentAudio<1) currentAudio=6;


            }
        });



    }

}
