package com.adiselav.formular;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

public class FormularStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formular_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn = findViewById(R.id.buttonAdaugareStudent);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numeEt = findViewById(R.id.editNume);
                String nume = numeEt.getText().toString();
                RadioGroup genRg = findViewById(R.id.editGen);
                RadioButton genRb = findViewById(genRg.getCheckedRadioButtonId());
                String gen = genRb.getText().toString();
                Spinner facultateSp = findViewById(R.id.editFacultate);
                String facultate = facultateSp.getSelectedItem().toString();
                Switch restantaSw = findViewById(R.id.editRestanta);
                Boolean restanta = restantaSw.isChecked();
                EditText venitEt = findViewById(R.id.editVenit);
                float venit = Float.parseFloat(venitEt.getText().toString());
                DatePicker dataDp = findViewById(R.id.editData);
                int year = dataDp.getYear();
                int month = dataDp.getMonth();
                int day = dataDp.getDayOfMonth();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day);
                Date data = calendar.getTime();

                Student student = new Student(nume, gen, facultate, restanta, venit, data);
                Toast.makeText(FormularStudent.this, student.toString(), Toast.LENGTH_LONG).show();

                Intent it = new Intent();
                it.putExtra("student", student);
                setResult(RESULT_OK, it);
                finish();

            }
        });

    }
}