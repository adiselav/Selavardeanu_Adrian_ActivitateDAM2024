package com.adiselav.exemplu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListaStudenti extends AppCompatActivity {

    private List<Student> studentList= null;
    private int idModificat=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_studenti);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //trimitem lista de studenti din MainActivity printr-un intent
        Intent it = getIntent();
        //lista students de aici devine egala cu studentList din MainActivity
        studentList = it.getParcelableArrayListExtra("studenti");

        ListView lv = findViewById(R.id.studentiLV);

        //mergem pe varianta array adapter default
        //ne trebuie un adaptor pentru lista
        ArrayAdapter<Student> adaptor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, studentList);
        lv.setAdapter(adaptor);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ListaStudenti.this, studentList.get(position).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentModifica = new Intent(getApplicationContext(), FormularAdaugare.class);
                intentModifica.putExtra("studenti", studentList.get(position));
                idModificat = position;
                startActivityForResult(intentModifica, 200);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                studentList.remove(position);
                adaptor.notifyDataSetChanged();
                return false;
            }
        });

    }
}