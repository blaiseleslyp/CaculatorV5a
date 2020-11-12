package com.example.caculatorv5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("history");


        final ArrayList<String> list = getIntent().getStringArrayListExtra(MainActivity.HISTORY_EXTRA);
        TextView noContent = findViewById(R.id.no_content_text);
        noContent.setVisibility(list == null || list.isEmpty()? View.VISIBLE: View.INVISIBLE);


        ListView listView = findViewById(R.id.label);
        listView.setVisibility(list == null || list.isEmpty()? View.INVISIBLE: View.VISIBLE);



        if(list != null && !list.isEmpty())
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_item_layout, list.toArray(new String[list.size()]));


            listView.setAdapter(adapter);
            listView.setOnItemClickListener((parent, view, position, id) -> {
                String item = list.get(position);
                Log.d("History", "Selected" + item);
            });
        }
    }
}
