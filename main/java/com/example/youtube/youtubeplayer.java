package com.example.youtube;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class youtubeplayer extends YouTubeBaseActivity
{
    YouTubePlayerView ytplayer;
    YouTubePlayer.OnInitializedListener aOnInitializedListener;
    String URLID;
    private int vidcurrentpos = 0;
    private int mstatepos = 0;
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtubeplayer);
        ytplayer = findViewById(R.id.youtubeplayer);
        String yturl = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            yturl = extras.getString(youtubeapi.URL_KEY);
        }
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(yturl);
        if(matcher.find())
        {
            URLID = matcher.group();
        }
        else {
            Toast.makeText(this, "URL link failed", Toast.LENGTH_SHORT).show();
        }
        aOnInitializedListener = new YouTubePlayer.OnInitializedListener()
        {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {
                youTubePlayer.loadVideo(URLID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
            {

            }
        };
        ytplayer.initialize(youtubeapi.getApiKey(),aOnInitializedListener);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState)
    {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
