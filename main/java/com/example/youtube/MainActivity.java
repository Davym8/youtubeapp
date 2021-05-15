package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText urltext;
    Button playbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urltext = findViewById(R.id.urlbar);
        playbutton = findViewById(R.id.playbutton);
    }
    public void setPlaybutton(View view)
    {
        if (urltext.getText().toString().isEmpty())
        {
            Toast.makeText(this, "URL IS EMPTY", Toast.LENGTH_SHORT).show();
        }
        else{
            String yturl = urltext.getText().toString();
            Intent intent = new Intent(this, youtubeplayer.class);
            intent.putExtra(youtubeapi.URL_KEY, yturl);
            startActivity(intent);
        }

    }
}