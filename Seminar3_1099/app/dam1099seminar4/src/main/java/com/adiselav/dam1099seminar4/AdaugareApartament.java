package com.adiselav.dam1099seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareApartament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_apartament);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        Intent intent = getIntent();
        if (intent.hasExtra("apartament"))
        {
            Apartament apartament = intent.getParcelableExtra("apartament");
            EditText adresaET = findViewById(R.id.EditAdresa);
            EditText camereET = findViewById(R.id.EditNrCamere);
            EditText anET = findViewById(R.id.EditAnConstructie);
            EditText suprafataET = findViewById(R.id.EditSuprafata);
            CheckBox balconCB = findViewById(R.id.CheckBalcon);

            adresaET.setText(apartament.getAdresa());
            camereET.setText(String.valueOf(apartament.getNrCamere()));
            anET.setText(String.valueOf(apartament.getAnConstructie()));
            suprafataET.setText(String.valueOf(apartament.getSuprafata()));
            balconCB.setChecked(apartament.isBalcon());

        }

        Button btnAdaugareApartament=findViewById(R.id.buttonAdaugareApartament);
        btnAdaugareApartament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etAdresa=findViewById(R.id.EditAdresa);
                String adresa=etAdresa.getText().toString();
                EditText etNrCamere=findViewById(R.id.EditNrCamere);
                int nrCamere=Integer.parseInt(etNrCamere.getText().toString());
                EditText etConstructie=findViewById(R.id.EditAnConstructie);
                int anConstructie=Integer.parseInt(etConstructie.getText().toString());
                EditText etSuprafata=findViewById(R.id.EditSuprafata);
                float suprafata=Float.parseFloat(etSuprafata.getText().toString());
                CheckBox cbBalcon=findViewById(R.id.CheckBalcon);
                boolean balcon=((CheckBox)findViewById(R.id.CheckBalcon)).isChecked();

                Apartament apartament = new Apartament(adresa,nrCamere,anConstructie,suprafata,balcon);

                Intent it = new Intent();
                it.putExtra("apartament",apartament);
                Toast.makeText(AdaugareApartament.this, apartament.toString(), Toast.LENGTH_SHORT).show();
                //terminam activitatea
                setResult(RESULT_OK,it);
                finish();


            }
        });

    }
}