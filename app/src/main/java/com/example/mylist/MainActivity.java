package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private ListView listView;
        private List<String> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListViewId);
        if (List == null)
        {
            if (!loadlist())
            {
                return;
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_detalle_list,R.id.textViewId,List);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toast(position);
            }

            private void toast(int position) {
                Toast.makeText(getBaseContext(),List.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }


    private boolean loadlist() {
        List = new ArrayList<String>();
        for(int i=1; i<=100; i++)
        {
            List.add(String.format("Name %d", i));
        }
        return List != null && List.size() > 0;

    }
}