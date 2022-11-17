package com.example.kucharska;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaPrzepisowActivity extends AppCompatActivity {
Button button;
    ArrayAdapter<Przepis> adapterPrzepisy;
    ListView ListaViewPrzepisy;
    public static final String EXTRA_IDPRZEPISU="id_przepisu";
    public static final String EXTRA_KATEGORIA="id_kategorii";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_przepisow);
        int kategoria=(int)getIntent().getExtras().get(MainActivity.EXTRA_KATEGORIA);
        Toast.makeText(this,Integer.toString(kategoria), Toast.LENGTH_SHORT).show();
        ArrayList<Przepis> wybranePrzepisy=RepozytoriumPrzepisow.wybierzPrzepisy(kategoria);
        adapterPrzepisy=
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                        wybranePrzepisy);

        ListaViewPrzepisy=findViewById(R.id.listaViewPrzepisow);
        ListaViewPrzepisy.setAdapter(adapterPrzepisy);

    ListaViewPrzepisy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            Intent intencja=new Intent(ListaPrzepisowActivity.this,PrzepisActivity.class);
            intencja.putExtra(EXTRA_IDPRZEPISU,i);
            intencja.putExtra(EXTRA_KATEGORIA,kategoria);
            startActivity(intencja);
        }
    });
    button=findViewById(R.id.button2);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText Text;
            Text=findViewById(R.id.editTextTextPersonName);
            String nazwaPrzepisu=Text.getText().toString();
            Przepis przepisDodany=new Przepis(nazwaPrzepisu,2,"mąka, cukier",R.drawable.gofry);
            wybranePrzepisy.add(przepisDodany);
            adapterPrzepisy.notifyDataSetChanged();
        }
    });

    }

}