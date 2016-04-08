package com.mehstudios.tunnelsandmonsters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        question1();
    }

    private void question1(){
        Button button1 = (Button)findViewById(R.id.btn_1);
        Button button2 = (Button)findViewById(R.id.btn_2);
        Button button3 = (Button)findViewById(R.id.btn_3);
        TextView question = (TextView)findViewById(R.id.question);

        question.setText("Pick a race.");

        button1.setText("Elf");
        button2.setText("Mage");
        button3.setText("Barbarian");

        button1.setOnClickListener(button1q1);
        button2.setOnClickListener(button2q1);
        button3.setOnClickListener(button3q1);
    }

    private View.OnClickListener button1q1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("race", 1);
            editor.commit();
            question2();
        }
    };

    private View.OnClickListener button2q1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("race", 2);
            editor.commit();
            question2();
        }
    };

    private View.OnClickListener button3q1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("race", 3);
            editor.commit();
            question2();
        }
    };

    private void question2(){
        Button button1 = (Button)findViewById(R.id.btn_1);
        Button button2 = (Button)findViewById(R.id.btn_2);
        Button button3 = (Button)findViewById(R.id.btn_3);
        TextView question = (TextView)findViewById(R.id.question);

        question.setText("Pick an element.");

        button1.setText("Grass");
        button2.setText("Water");
        button3.setText("Fire");

        button1.setOnClickListener(button1q2);
        button2.setOnClickListener(button2q2);
        button3.setOnClickListener(button3q2);
    }

    private View.OnClickListener button1q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("water", 0);
            editor.putInt("fire", 0);
            editor.putInt("grass", 5);
            editor.commit();
            resumeGame();
        }
    };

    private View.OnClickListener button2q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("water", 5);
            editor.putInt("fire", 0);
            editor.putInt("grass", 0);
            editor.commit();
            resumeGame();
        }
    };

    private View.OnClickListener button3q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("water", 0);
            editor.putInt("fire", 5);
            editor.putInt("grass", 0);
            editor.commit();
            resumeGame();
        }
    };

    private void resumeGame(){
        Intent resumeGame = new Intent(this, VillageMenu.class);
        startActivity(resumeGame);
    }
}
