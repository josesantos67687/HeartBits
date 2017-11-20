package com.example.jose.heartbits;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Registos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registos);
        String[] fruits = new String[] {
                "Cape Gooseberry",
                "Capuli cherry"
        };
        List<String> list = new ArrayList<String>(Arrays.asList(fruits));

        ListView lv = (ListView) findViewById(R.id.listaregistos);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(arrayAdapter);

    }
}
