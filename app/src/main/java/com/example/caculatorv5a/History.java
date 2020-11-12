package com.example.caculatorv5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("history");


        final ArrayList<String> list = getIntent().getStringArrayListExtra(MainActivity.HISTORY_EXTRA);
        TextView noContent = findViewById(R.id.)
    }
}
