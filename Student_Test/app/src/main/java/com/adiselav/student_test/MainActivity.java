package com.adiselav.student_test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    EditText etNume;
    EditText etVarsta;
    EditText etJSON;
    StudentDatabase database = null;
    List<Student> studenti = null;
    StudentDAO studentDAO;
    String rezultat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        studenti = new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNume = findViewById(R.id.etNumee);
        etVarsta = findViewById(R.id.etVarsta);
        etJSON = findViewById(R.id.ETjson);

       studentDAO = StudentDatabase.getInstance(getApplicationContext()).getStudentiDao();

        Button btnSalvare = findViewById(R.id.btnSALVARE);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nume = etNume.getText().toString();
                int varsta = Integer.parseInt(etVarsta.getText().toString());
                boolean integralist = true;
                Student student = new Student(nume, varsta, integralist);
                studentDAO.adaugaStudent(student);
                etNume.setText("");
                etVarsta.setText("");
            }
        });


        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        Button btnIncarca = findViewById(R.id.btnINCARCARE);
        btnIncarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            URL url = new URL("https://pdm.ase.ro/curse.json");
                            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String linie = "";
                            StringBuilder sb = new StringBuilder();
                            while((linie = reader.readLine())!=null){
                                sb.append(linie);
                            }
                            JSONObject obj = new JSONObject(sb.toString());
                            JSONArray studenti = obj.getJSONArray("curse");
                            for(int i = 0; i < studenti.length(); i++){
                                JSONObject studentJSON = studenti.getJSONObject(i);
                                Student student = new Student();
                                student.setNume(studentJSON.getString("destinatie"));
                                student.setVarsta(Integer.parseInt(studentJSON.getString("distanta")));
                                student.setIntegralist(false);
                                studentDAO.adaugaStudent(student);
                                rezultat += "\n" + student;
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                etJSON.setText(rezultat);
            }
        });


        Button btnStergere = findViewById(R.id.btnStergere);
        btnStergere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentDAO.deleteIntegralisti();
            }
        });

        int numar = studentDAO.nrStudenti();
        Toast.makeText(MainActivity.this, numar + " inregistrari", Toast.LENGTH_SHORT).show();

        Button btnLista = findViewById(R.id.btnLista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ListaStudenti.class);
                startActivity(it);
            }
        });

        Button btnListaFav = findViewById(R.id.btnFavorite);
        btnListaFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ListaStudentiFavoriti.class);
                startActivity(it);
            }
        });
    }
}