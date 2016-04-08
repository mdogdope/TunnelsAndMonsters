package com.mehstudios.tunnelsandmonsters;

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
        Button button4 = (Button)findViewById(R.id.btn_4);
        TextView question = (TextView)findViewById(R.id.question);

        question.setText("Pick a race.");

        button1.setText("Elf");
        button2.setText("Mage");
        button3.setText("Barbarian");
        button4.setText("Dwarf");

        button1.setOnClickListener(button1q1);
    }

    private View.OnClickListener button1q1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
