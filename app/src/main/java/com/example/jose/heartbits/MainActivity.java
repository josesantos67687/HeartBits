package com.example.jose.heartbits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            //new DatabaseDAO().start();

        username = (EditText) findViewById(R.id.username);
        username.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchOperacao();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == username) {
            username.setText("");
        }
    }

    private void launchOperacao() {

        Intent intent = new Intent(this, Operacao.class);
        startActivity(intent);
    }
}
