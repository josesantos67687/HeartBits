package com.example.jose.heartbits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jose.heartbits.barcode.BarcodeCaptureActivity;
import com.google.android.gms.vision.barcode.Barcode;


public class Operacao extends AppCompatActivity {
    private int cama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operacao);

        Button registar = (Button) findViewById(R.id.registar);
        Button registos = (Button) findViewById(R.id.registos);
        Button dashboard = (Button) findViewById(R.id.dashboard);
        Button procedimento = (Button) findViewById(R.id.procedimento);


        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchRegistar();
        }
        });



        registos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchRegistos();
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchDashboard();
            }
        });

        procedimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchProcedimento();
            }
        });

    }



    private void launchRegistar() {

        Intent intent = new Intent(this, BarcodeCaptureActivity.class);
        startActivity(intent);
    }

    private void launchRegistos() {

        Intent intent = new Intent(this, Registos.class);
        startActivity(intent);
    }

    private void launchDashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    private void launchProcedimento() {

        Intent intent = new Intent(this, Procedimentos.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cama = Integer.parseInt(data.getStringExtra("key"));
        System.out.println(cama);
    }
}
