package com.example.kucharska;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listViewKategorie;
public static final String EXTRA_KATEGORIA="idKategori";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewKategorie=findViewById(R.id.listaView);
        listViewKategorie.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                       wyswietlNowaAktywnosc(i);
                     /*   String kategoria=parent.getItemAtPosition(i).toString();
                        Toast.makeText(MainActivity.this, kategoria+"pod indeksem"+i, Toast.LENGTH_SHORT).show();
                    */
                    }

                }
        );
    }
    private void wyswietlNowaAktywnosc(int kategoria){
        Intent intencja=new Intent(this,ListaPrzepisowActivity.class);
        intencja.putExtra(EXTRA_KATEGORIA,kategoria);
        startActivity(intencja);
    }
}