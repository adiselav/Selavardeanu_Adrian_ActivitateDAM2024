package com.adiselav.exemplu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        studentList = new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //CREARE STUDENT:
        Button btn = findViewById(R.id.butonFormular);
        //METODA PRIN CARE DESCHIDEM O NOUA ACTIVITATE DIN ACTIVITATEA CURENTA
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), FormularAdaugare.class);
                startActivityForResult(it,200);
            }
        });

        //AFISARE IN LISTA CU ADAPTER DEFAULT ANDROID STUDIO:
        Button butonulMeu = findViewById(R.id.butonLista);
        butonulMeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaStudenti.class);
                intent.putParcelableArrayListExtra("studenti", (ArrayList<? extends Parcelable>) studentList);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200){
            if (resultCode==RESULT_OK){
                Student student = data.getParcelableExtra("student");
                Toast.makeText(this, "MAIN", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, student.toString(), Toast.LENGTH_LONG).show();
                studentList.add(student);
            }
        }
    }
}