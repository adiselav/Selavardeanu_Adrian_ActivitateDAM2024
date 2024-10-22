package com.adiselav.dam1099seminar4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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

                Apartament ap = new Apartament(adresa,nrCamere,anConstructie,suprafata,balcon);

            }
        });
    }
}