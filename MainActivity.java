package com.example.mahe.touch;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float x = 0, y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseClass entry = new DatabaseClass(MainActivity.this);
        boolean flag = true;
        try {
            entry.open();
            entry.createEntry(Float.toString(x), Float.toString(y));
            entry.close();
        } catch (Exception e) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Not Working", Toast.LENGTH_LONG).show();
        } finally {
            if (flag)
                Toast.makeText(getApplicationContext(), "Working", Toast.LENGTH_SHORT).show();
        }
        final CanvasView canvas = (CanvasView) findViewById(R.id.paint_view);

        // Setting touch event listener for the PaintView
        Button data = (Button) findViewById(R.id.db);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DbActivity.class);
                startActivity(i);
            }
        });
    }
}