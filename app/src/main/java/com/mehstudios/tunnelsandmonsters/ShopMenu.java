package com.mehstudios.tunnelsandmonsters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShopMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_menu);

        displayPoints();

        String type = "fire";
        displayLvlValues(type);
        type = "water";
        displayLvlValues(type);
        type = "earth";
        displayLvlValues(type);
        type = "air";
        displayLvlValues(type);

        LinearLayout buttonFireItem = (LinearLayout)findViewById(R.id.fire_list_item);
        LinearLayout buttonWaterItem = (LinearLayout)findViewById(R.id.water_list_item);
        LinearLayout buttonEarthItem = (LinearLayout)findViewById(R.id.earth_list_item);
        LinearLayout buttonAirItem = (LinearLayout)findViewById(R.id.air_list_item);
        ImageView backButton = (ImageView)findViewById(R.id.shop_back_button);

        buttonFireItem.setOnClickListener(buttonFireItemClick);
        buttonWaterItem.setOnClickListener(buttonWaterItemClick);
        buttonEarthItem.setOnClickListener(buttonEarthItemClick);
        buttonAirItem.setOnClickListener(buttonAirItemClick);
        backButton.setOnClickListener(buttonBackClick);
    }

    //Below is the function that sets the level values in the needed areas
    private void displayLvlValues(String type){
        SharedPreferences getStats = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
        int stats = getStats.getInt(type, 0);

        if (type == "fire"){
            TextView textView = (TextView)findViewById(R.id.shop_fire_level_text_view);
            textView.setText("Lvl " + stats);
        }else if (type == "water"){
            TextView textView = (TextView)findViewById(R.id.shop_water_level_text_view);
            textView.setText("Lvl " + stats);
        }else if (type == "earth"){
            TextView textView = (TextView)findViewById(R.id.shop_earth_level_text_view);
            textView.setText("Lvl " + stats);
        }else if (type == "air") {
            TextView textView = (TextView) findViewById(R.id.shop_air_level_text_view);
            textView.setText("Lvl " + stats);
        }
    }

    private void displayPoints(){
        TextView pointsTextView = (TextView)findViewById(R.id.shop_points_text_view);
        SharedPreferences preferences = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);
        int points = preferences.getInt("points", 0);
        pointsTextView.setText(points + "");
    }

    //Below are OnClickListeners for the buttons and the functions to increase the element level
    private View.OnClickListener buttonFireItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fireClick();
        }
    };

    private View.OnClickListener buttonWaterItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            waterClick();
        }
    };

    private View.OnClickListener buttonEarthItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            earthClick();
        }
    };

    private View.OnClickListener buttonAirItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            airClick();
        }
    };

    private View.OnClickListener buttonBackClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            backToVillage();
        }
    };

    private void fireClick(){
        SharedPreferences getPlayerStats = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);

        int points = getPlayerStats.getInt("points", 0);
        if (points > 0){
            int tempStat = getPlayerStats.getInt("fire", 0);
            tempStat += 1;
            points -= 1;

            SharedPreferences.Editor editor = getPlayerStats.edit();
            editor.putInt("fire", tempStat);
            editor.putInt("points", points);
            editor.commit();


            String type = "fire";
            displayLvlValues(type);
            displayPoints();
        }else{
            Toast.makeText(getApplicationContext(), "You have no more points", Toast.LENGTH_SHORT).show();
        }
    }

    private void waterClick(){
        SharedPreferences getPlayerStats = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);

        int points = getPlayerStats.getInt("points", 0);
        if (points > 0){
            int tempStat = getPlayerStats.getInt("water", 0);
            tempStat += 1;
            points -= 1;

            SharedPreferences.Editor editor = getPlayerStats.edit();
            editor.putInt("water", tempStat);
            editor.putInt("points", points);
            editor.commit();


            String type = "water";
            displayLvlValues(type);
            displayPoints();
        }else{
            Toast.makeText(getApplicationContext(), "You have no more points", Toast.LENGTH_SHORT).show();
        }
    }

    private void earthClick(){
        SharedPreferences getPlayerStats = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);

        int points = getPlayerStats.getInt("points", 0);
        if (points > 0){
            int tempStat = getPlayerStats.getInt("earth", 0);
            tempStat += 1;
            points -= 1;

            SharedPreferences.Editor editor = getPlayerStats.edit();
            editor.putInt("earth", tempStat);
            editor.putInt("points", points);
            editor.commit();


            String type = "earth";
            displayLvlValues(type);
            displayPoints();
        }else{
            Toast.makeText(getApplicationContext(), "You have no more points", Toast.LENGTH_SHORT).show();
        }
    }

    private void airClick(){
        SharedPreferences getPlayerStats = getSharedPreferences("PlayerStats", Context.MODE_PRIVATE);

        int points = getPlayerStats.getInt("points", 0);
        if (points > 0){
            int tempStat = getPlayerStats.getInt("air", 0);
            tempStat += 1;
            points -= 1;

            SharedPreferences.Editor editor = getPlayerStats.edit();
            editor.putInt("air", tempStat);
            editor.putInt("points", points);
            editor.commit();


            String type = "air";
            displayLvlValues(type);
            displayPoints();
        }else{
            Toast.makeText(getApplicationContext(), "You have no more points", Toast.LENGTH_SHORT).show();
        }
    }

    private void backToVillage(){
        Intent villageMenu = new Intent(this, VillageMenu.class);
        startActivity(villageMenu);
    }
}
