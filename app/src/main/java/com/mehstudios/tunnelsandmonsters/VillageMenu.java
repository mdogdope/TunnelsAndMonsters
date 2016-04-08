package com.mehstudios.tunnelsandmonsters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VillageMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village_menu);

        ImageView adventureButton = (ImageView)findViewById(R.id.adventure_button);
        ImageView shopButton = (ImageView)findViewById(R.id.shop_button);

        adventureButton.setOnClickListener(adventureButtonClick);
        shopButton.setOnClickListener(shopButtonClick);
    }

    private View.OnClickListener adventureButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            adventureIntent();
        }
    };

    private View.OnClickListener shopButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            shopMenuIntent();
        }
    };

    private void shopMenuIntent(){
        Intent shopMenu = new Intent(this, ShopMenu.class);
        startActivity(shopMenu);
    }

    private void adventureIntent(){
        Intent adventure = new Intent(this, Adventure.class);
        startActivity(adventure);
    }
}
