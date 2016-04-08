package com.mehstudios.tunnelsandmonsters;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
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

        ImageView playButton = (ImageView)findViewById(R.id.new_game_button);
        ImageView resumeButton = (ImageView)findViewById(R.id.resume_button);

        playButton.setOnClickListener(newGameButtonClick);
        resumeButton.setOnClickListener(resumeButtonClick);
    }

    private View.OnClickListener newGameButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            confirmDialog();
        }
    };

    private void newGameActivity(){
        Intent newGame = new Intent(this, NewGame.class);
        startActivity(newGame);
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?\nThis will clear saved game data.")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        newGameActivity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    private View.OnClickListener resumeButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resumeGame();
        }
    };

    private void resumeGame(){
        Intent resumeGame = new Intent(this, VillageMenu.class);
        startActivity(resumeGame);
    }
}
