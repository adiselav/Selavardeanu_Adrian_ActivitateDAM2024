package com.adiselav.dam1099seminar4;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.util.Log;

public class WeatherActivity extends AppCompatActivity {
    public String cheieOras = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnApelare = findViewById(R.id.buttonApelareAPI);
        btnApelare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText orasET = findViewById(R.id.EditOras);

                String apiKey = BuildConfig.API_KEY;
                String link = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="+apiKey+"&q="+orasET.getText().toString();

                Executor executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.myLooper());

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        HttpURLConnection connection = null;
                        URL url = null;
                        try {
                            url = new URL(link);
                            connection = (HttpURLConnection) url.openConnection();
                            InputStream is = connection.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader reader = new BufferedReader(isr);
                            StringBuilder response = new StringBuilder();
                            String line;
                            while((line = reader.readLine())!=null)
                            {
                                response.append(line);
                            }

                            JSONArray vector = new JSONArray(response.toString());
                            JSONObject obiect = vector.getJSONObject(0);
                            cheieOras = obiect.getString("Key");

                        } catch (IOException | JSONException e) {
                            throw new RuntimeException(e);
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                TextView afisare = findViewById(R.id.TVafisare);
                                afisare.setText(cheieOras);

                            }
                        });
                    }

                });
            }
        });
    }
}

