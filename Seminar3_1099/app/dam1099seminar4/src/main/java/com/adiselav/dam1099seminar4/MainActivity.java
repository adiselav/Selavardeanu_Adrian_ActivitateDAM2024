package com.adiselav.dam1099seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //declarare lista de obiecte
    private List<Apartament> apartamente=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //initializare lista de obiecte
        apartamente = new ArrayList<>();

        String adresa1="Piata Romana nr.1 ";
        int nrCamere1=1;
        int anConstructie1=1960;
        float suprafata1=19.90f;
        boolean balcon1=true;
        apartamente.add(new Apartament(adresa1,nrCamere1,anConstructie1,suprafata1,balcon1));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //button

        Button btn=findViewById(R.id.Butonulmeu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(), AdaugareApartament.class);
                startActivityForResult(it,403);
            }
        });

        Button butonLista=findViewById(R.id.buttonLV);
        butonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(), ListaApartamente.class);
                it.putParcelableArrayListExtra("apartamente", (ArrayList<? extends Parcelable>) apartamente);
                startActivity(it);
            }
        });

        Button butonListaImagini = findViewById(R.id.buttonListaImagini);
        butonListaImagini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaImagini.class);
                startActivity(intent);
            }
        });

        Button butonVreme = findViewById(R.id.buttonWeather);
        butonVreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);
                startActivity(intent);
            }
        });

        Button butonFavorite = findViewById(R.id.buttonFavorite);
        butonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ApartamenteFavorite.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==403){
            if (resultCode==RESULT_OK){
                Apartament apartament=data.getParcelableExtra("apartament");
                apartamente.add(apartament);
            }
        }
    }
    //end button
}