package com.adiselav.exemplu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
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

public class FormularAdaugare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formular_adaugare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //--------------------------------------------------------------------------------
        //modificare
        Intent it = getIntent();
        if (it.hasExtra("studenti")){
            Student student = it.getParcelableExtra("studenti");
            EditText numeEt = findViewById(R.id.editNume);
            EditText varstaEt = findViewById(R.id.editVarsta);
            RadioGroup sexRg = findViewById(R.id.editSex);
            RadioButton sexRb = findViewById(sexRg.getCheckedRadioButtonId());
            CheckBox integralistCb = findViewById(R.id.editIntegralist);
            Switch licentaSw = findViewById(R.id.editLicenta);
            RatingBar venitRb = findViewById(R.id.editVenit);
            Spinner specializareSp = findViewById(R.id.editSpecializare);
            DatePicker dataDp = findViewById(R.id.editData);

            numeEt.setText(student.getNume());
            varstaEt.setText(String.valueOf(student.getVarsta()));
            sexRb.setText(student.getSex());
            integralistCb.setChecked(student.isIntegralist());
            licentaSw.setChecked(student.isLicenta());
            venitRb.setRating(student.getVenit());
            ArrayAdapter adapter = (ArrayAdapter)specializareSp.getAdapter();
            int position = adapter.getPosition(student.getSpecializare());
            specializareSp.setSelection(position);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(student.getDataNastere());
            dataDp.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));


        }
        //--------------------------------------------------------------------------------


        Button btn = findViewById(R.id.butonAdaugareStudent);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText numeEt = findViewById(R.id.editNume);
                String nume = numeEt.getText().toString();

                EditText varstaEt = findViewById(R.id.editVarsta);
                int varsta = Integer.parseInt(varstaEt.getText().toString());

                RadioGroup sexRg = findViewById(R.id.editSex);
                RadioButton sexRb = findViewById(sexRg.getCheckedRadioButtonId());
                String sex = sexRb.getText().toString();

                CheckBox integralistCb = findViewById(R.id.editIntegralist);
                boolean integralist = integralistCb.isChecked();

                Switch licentaSw = findViewById(R.id.editLicenta);
                boolean licenta = licentaSw.isChecked();

                RatingBar venitRb = findViewById(R.id.editVenit);
                float venit = venitRb.getRating();

                Spinner specializareSp = findViewById(R.id.editSpecializare);
                String specializare = specializareSp.getSelectedItem().toString();

                DatePicker dataDp = findViewById(R.id.editData);
                int year = dataDp.getYear();
                int month = dataDp.getMonth();
                int day = dataDp.getDayOfMonth();
                Calendar calendar = Calendar.getInstance();
                Date dataNastere = calendar.getTime();

                Student student = new Student(nume,varsta,sex,integralist,licenta,venit,specializare,dataNastere);
                Toast.makeText(FormularAdaugare.this, student.toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("student",student);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
//        private String nume; //EditText
//        private int varsta; //EditText
//        private String sex; //RadioButton
//        private boolean integralist; //CheckBox
//        private boolean licenta; //Switch
//        private float venit; //RatingBar
//        private String specializare; //Spinner
//        private Date dataNastere; //DatePicker
    }
}