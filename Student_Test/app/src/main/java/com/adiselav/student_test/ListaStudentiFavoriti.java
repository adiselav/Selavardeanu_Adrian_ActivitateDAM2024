package com.adiselav.student_test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListaStudentiFavoriti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_studenti_favoriti);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sp = getSharedPreferences("obiecteFavorite", MODE_PRIVATE);
        Map<String, String> dictionar = (Map<String, String>)sp.getAll();
        List<String> studentiFavoriti = new ArrayList<>();
        for(Map.Entry<String, String> obiect: dictionar.entrySet()){
            studentiFavoriti.add(obiect.getValue());
        }

        ListView lv = findViewById(R.id.lvStudentiFavoriti);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, studentiFavoriti);
        lv.setAdapter(adapter);
    }
}