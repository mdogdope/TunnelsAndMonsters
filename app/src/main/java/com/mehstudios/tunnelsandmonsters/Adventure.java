package com.mehstudios.tunnelsandmonsters;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class Adventure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        //Drag and Drop============================
        findViewById(R.id.fire_list_item_adv).setOnLongClickListener(longClickListener);
        findViewById(R.id.water_list_item_adv).setOnLongClickListener(longClickListener);
        findViewById(R.id.earth_list_item_adv).setOnLongClickListener(longClickListener);
        findViewById(R.id.air_list_item_adv).setOnLongClickListener(longClickListener);

        findViewById(R.id.drop_target).setOnDragListener(dragListener);
        //=========================================
    }

    //Drag and Drop============================
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            DragShadow dragShadow = new DragShadow(v);

            View.DragShadowBuilder myShadowBuilder = new DragShadow(v);

            ClipData data = ClipData.newPlainText("", "");
            v.startDrag(data, dragShadow, v, 0);
            return false;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener()
    {
        @Override
        public boolean onDrag(View v, DragEvent event)
        {
            int dragEvent = event.getAction();
            TextView dropText = (TextView) v;

            switch(dragEvent)
            {
                case DragEvent.ACTION_DRAG_ENTERED:
                    //dropText.setTextColor(Color.GREEN);
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    //dropText.setTextColor(Color.RED);
                    break;

                case DragEvent.ACTION_DROP:
                    TextView target = (TextView)findViewById(R.id.drop_target);
                    target.setText("Dropped");
                    break;
            }

            return true;
        }

    };

    private class DragShadow extends View.DragShadowBuilder{

        ColorDrawable grayBox;

        public DragShadow(View view){
            super(view);
            grayBox = new ColorDrawable(Color.LTGRAY);
        }

        public void onDrawShadow(Canvas canvas){
            //super.onDrawShadow(canvas);
            grayBox.draw(canvas);
        }

        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint){
            //super.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
            View v = getView();

            int height = (int)v.getHeight()/2;
            int width = (int)v.getWidth()/2;

            grayBox.setBounds(0, 0 , width, height);

            shadowSize.set(width, height);

            shadowTouchPoint.set((int)width/2, (int)height/2);
        }
    }
    //========================================
}
