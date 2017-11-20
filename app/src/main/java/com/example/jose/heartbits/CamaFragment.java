package com.example.jose.heartbits;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class CamaFragment extends Fragment{

    public Cama cama;

    @SuppressLint("ValidFragment")
    public CamaFragment(Cama cama){
        this.cama=cama;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        //inflater.createView("Alertas",null,)
        return inflater.inflate(R.layout.cama_fragment,container,false);
    }
}
