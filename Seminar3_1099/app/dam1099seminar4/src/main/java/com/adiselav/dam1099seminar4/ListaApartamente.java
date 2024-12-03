package com.adiselav.dam1099seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaApartamente extends AppCompatActivity {
    private List<Apartament> apartamente=null;
    private int idModificat=0;
    private ApartamentAdapter adapter=null;
    private ApartamentDatabase apartamentDatabase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_apartamente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            return insets;
        });

        Intent it=getIntent();
        apartamente = it.getParcelableArrayListExtra("apartamente");

        ListView lv = findViewById(R.id.apartamenteLV);

//        ArrayAdapter<Apartament> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,apartamente);
//        lv.setAdapter(adapter);
//        adapter=new ApartamentAdapter(apartamente,getApplicationContext(),R.layout.row_item);
//        lv.setAdapter(adapter);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                Toast.makeText(ListaApartamente.this, apartamente.get(i).toString(), Toast.LENGTH_LONG).show();
//            }
//        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    apartamente = apartamentDatabase.getDaoObject().getApartamente();
                } finally {
                    handler.post(()-> {
                        adapter = new ApartamentAdapter(apartamente, getApplicationContext(), R.layout.row_item);
                        lv.setAdapter(adapter);
                    });
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intentModifica = new Intent(getApplicationContext(), AdaugareApartament.class);
                intentModifica.putExtra("apartament", apartamente.get(position));
                idModificat = position;
                startActivityForResult(intentModifica,403);
                Toast.makeText(ListaApartamente.this, apartamente.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                apartamente.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode==403)
            {
                apartamente.set(idModificat,data.getParcelableExtra("apartament"));
                adapter.notifyDataSetChanged();
            }
        }
    }
}