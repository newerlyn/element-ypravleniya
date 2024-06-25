package com.example.myandroidproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private float startX;
    private float startY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View mainView = findViewById(R.id.main_view);

        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        float endX = event.getX();
                        float endY = event.getY();

                        float deltaX = Math.abs(endX - startX);
                        float deltaY = Math.abs(endY - startY);

                        if (deltaX > deltaY) {
                            mainView.setBackgroundColor(Color.GREEN);
                        } else if (deltaY > deltaX) {
                            mainView.setBackgroundColor(Color.YELLOW);
                        } else {
                            mainView.setBackgroundColor(Color.RED);
                        }
                        return true;
                }
                return false;
            }
        });
    }
}
