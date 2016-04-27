package com.mehstudios.tunnelsandmonsters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        Button button4 = (Button)findViewById(R.id.btn_4);
        TextView question = (TextView)findViewById(R.id.question);

        question.setText("Pick a race.");

        button1.setText("Elf");
        button2.setText("Human");
        button3.setText("Dwarf");
        button4.setText("Orc");

        button1.setOnClickListener(button1q1);
        button2.setOnClickListener(button2q1);
        button3.setOnClickListener(button3q1);
        button4.setOnClickListener(button4q1);
    }

    private View.OnClickListener button1q1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("race", 1);
            editor.putInt("water", 2);
            editor.putInt("fire", 1);
            editor.putInt("earth", 1);
            editor.putInt("air", 4);
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
            editor.putInt("water", 2);
            editor.putInt("fire", 2);
            editor.putInt("earth", 2);
            editor.putInt("air", 2);
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
            editor.putInt("water", 1);
            editor.putInt("fire", 1);
            editor.putInt("earth", 3);
            editor.putInt("air", 2);
            editor.commit();
            question2();
        }
    };

    private View.OnClickListener button4q1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("race", 4);
            editor.putInt("water", 2);
            editor.putInt("fire", 3);
            editor.putInt("earth", 1);
            editor.putInt("air", 1);
            editor.commit();
            question2();
        }
    };

    private void question2(){
        Button button1 = (Button)findViewById(R.id.btn_1);
        Button button2 = (Button)findViewById(R.id.btn_2);
        Button button3 = (Button)findViewById(R.id.btn_3);
        Button button4 = (Button)findViewById(R.id.btn_4);
        TextView question = (TextView)findViewById(R.id.question);

        question.setText("Pick an element.");

        button1.setText("Earth");
        button2.setText("Water");
        button3.setText("Fire");
        button4.setText("Air");

        button1.setOnClickListener(button1q2);
        button2.setOnClickListener(button2q2);
        button3.setOnClickListener(button3q2);
        button4.setOnClickListener(button4q2);
    }

    private View.OnClickListener button1q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            int tempVal = playerRacePref.getInt("earth", 0);
            tempVal += 3;

            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("earth", tempVal);
            editor.commit();
            resumeGame();
        }
    };

    private View.OnClickListener button2q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            int tempVal = playerRacePref.getInt("water", 0);
            tempVal += 3;

            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("water", tempVal);
            editor.commit();
            resumeGame();
        }
    };

    private View.OnClickListener button3q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            int tempVal = playerRacePref.getInt("fire", 0);
            tempVal += 3;

            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("fire", tempVal);
            editor.commit();
            resumeGame();
        }
    };

    private View.OnClickListener button4q2 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences playerRacePref = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
            int tempVal = playerRacePref.getInt("air", 0);
            tempVal += 3;

            SharedPreferences.Editor editor = playerRacePref.edit();
            editor.putInt("air", tempVal);
            editor.commit();
            resumeGame();
        }
    };

    private void resumeGame(){
        SharedPreferences preferences = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("points", 5);
        editor.commit();

        Intent resumeGame = new Intent(this, VillageMenu.class);
        startActivity(resumeGame);
    }
}
