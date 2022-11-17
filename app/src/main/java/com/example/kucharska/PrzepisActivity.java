package com.example.kucharska;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PrzepisActivity extends AppCompatActivity {
TextView textView;
TextView textViewSklad;
ImageView imageView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepis);
        int ktoryPrzepis=getIntent().getExtras().getInt(ListaPrzepisowActivity.EXTRA_IDPRZEPISU,0);
        int kategoria=getIntent().getExtras().getInt(ListaPrzepisowActivity.EXTRA_KATEGORIA,0);
        Przepis przepis=RepozytoriumPrzepisow.wybierzPrzepisy(kategoria).get(ktoryPrzepis);

        textView=findViewById(R.id.tytul);
        textViewSklad=findViewById(R.id.skladniki);
        imageView=findViewById(R.id.imageView);
        textView.setText(przepis.getNazwa());
        textViewSklad.setText(przepis.getListaSkladnikow());
        imageView.setImageResource(przepis.getIdObrazka());
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // w manifeście dodać filtr do wysyałania sms
                Intent intencja=new Intent();
                intencja.setAction(Intent.ACTION_SEND);
                intencja.putExtra(Intent.EXTRA_TEXT,przepis.getNazwa()+" "+przepis.getListaSkladnikow()+" smacznego");
                intencja.setType("text/plain");
                Intent podzielSięIntencja=Intent.createChooser(intencja,null);
                startActivity(podzielSięIntencja);

            }
        });


    }
}