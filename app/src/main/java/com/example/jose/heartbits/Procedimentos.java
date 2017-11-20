package com.example.jose.heartbits;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MarcosPro on 19/11/2017.
 */

public class Procedimentos extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedimentos_activity);

        String[] procedimentos = new String[] {
                "Procedimento1",
                "Procedimento2"
        };
        List<String> list = new ArrayList<String>(Arrays.asList(procedimentos));

        ListView lv = (ListView) findViewById(R.id.ListaProcedimentos);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);

        String url = "jdbc:mysql://192.168.137.1:3306/heartbits";
        String username = "root";
        String password = "";
        System.out.println(((TextView) v).getText());
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO registos " +
                    "VALUES ('Cama 1 - '" + ((TextView) v).getText() +
                     "- 17:40')";

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
