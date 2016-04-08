package com.mehstudios.tunnelsandmonsters;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ImageView playButton = (ImageView)findViewById(R.id.play_button);
        playButton.setOnClickListener(playButtonClick);
    }

    private View.OnClickListener playButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            newGameActivity();
        }
    };

    private void newGameActivity(){
        Intent newGame = new Intent(this, NewGame.class);
        startActivity(newGame);
    }
}
