package com.example.mahe.touch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.sql.SQLException;

public class DbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
        DatabaseClass db = new DatabaseClass(this);
        try {
            db.open();
            String data = db.getData();
            db.close();
            System.out.print("THE DATA IS " + data);
            tv.setText(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
