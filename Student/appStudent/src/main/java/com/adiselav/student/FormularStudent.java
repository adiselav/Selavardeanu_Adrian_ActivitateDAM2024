package com.adiselav.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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
        //inca suntem in onCreate
        Button butonulmeu = findViewById(R.id.btnAdaugareStudent);
        butonulmeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNume = findViewById(R.id.editNume);
                String nume = etNume.getText().toString();
                EditText etVarsta = findViewById(R.id.editVarsta);
                int varsta = Integer.parseInt(etVarsta.getText().toString());
                EditText etVenit = findViewById(R.id.editVenit);
                float venit = Float.parseFloat(etVenit.getText().toString());
                Spinner spFacultate = findViewById(R.id.editFacultate);
                String facultate = spFacultate.getSelectedItem().toString();
                DatePicker dpData = findViewById(R.id.editData);
                int year = dpData.getYear();
                int month = dpData.getMonth();
                int day = dpData.getDayOfMonth();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day);
                Date data = calendar.getTime();
                boolean integralist = ((CheckBox)findViewById(R.id.editIntegralist)).isChecked();

                Student student = new Student(nume,varsta,venit,facultate,data,integralist);
                Toast.makeText(FormularStudent.this, student.toString(), Toast.LENGTH_LONG).show();

                Intent it = new Intent();
                it.putExtra("student",student);
                setResult(RESULT_OK,it);
                finish();

            }
        });

    }
}