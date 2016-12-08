package com.example.qnd238.day;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    EditText number;
    Button next, pre, add;
    TextView header;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText) findViewById(R.id.number);
        next = (Button) findViewById(R.id.next);
        pre = (Button) findViewById(R.id.pre);
        add = (Button) findViewById(R.id.add);
        header = (TextView) findViewById(R.id.header);
        listView = (ListView) findViewById(R.id.week);

        String[] weekdays = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        final Day today = new Day();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, weekdays);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemPosition     = i;
                String  itemValue    = (String) listView.getItemAtPosition(i);
                today.setDay(itemValue);

                Toast.makeText(getApplicationContext(),
                        "Today is " + itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Tomorrow is " + today.nextDay() , Toast.LENGTH_LONG)
                        .show();
            }
        });

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Yesterday is " + today.preDay() , Toast.LENGTH_LONG)
                        .show();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(number.getText().toString());
                Toast.makeText(getApplicationContext(),
                        "The day is " + today.addDay(num) , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
