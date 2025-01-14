package com.adiselav.tramvai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Tramvai> tramvaiList = null;
    private TramvaiDatabase database = null;
    private TramvaiDAO tramvaiDAO;
    private EditText etModel;
    private String rezultat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tramvaiList = new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etModel = findViewById(R.id.etModel);

       tramvaiDAO = TramvaiDatabase.getInstance(getApplicationContext()).getDaoObject();

        Button btnCreaza = findViewById(R.id.btnCreaza);
        btnCreaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String model = etModel.getText().toString();
            }
        });
    }
}