package com.adiselav.dam1099seminar4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Adapter;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaImagini extends AppCompatActivity {

    private List<ImaginiDomeniu> lista = new ArrayList<>();;
    List<Bitmap> imagini = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_imagini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imagini = new ArrayList<>();
        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://mrexclusivitate.ro/oferte/4348/xlp__apartament-3-camere-de-inchiriat-obor-bucuresti_64e9c567c747a2.jpg");
        linkuriImagini.add("https://norisk.ro/oferte/257/xlp__apartament-3-camere-de-vanzare-colentina-bucuresti_62331cf78844e5.jpg");
        linkuriImagini.add("https://casevechi.ro/oferte/340/xlp__apartament-2-camere-de-vanzare-colentina-bucuresti_6480edf31c1f90.jpg");
        linkuriImagini.add("https://www.executarilicitatii.ro/wp-content/uploads/2024/01/Apartament-3-camere-Sector-2.jpg");
        linkuriImagini.add("https://murzea.ro/oferte/126/xlp__apartament-3-camere-de-vanzare-bucur-obor-bucuresti_6459142a82e654.jpg");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link:linkuriImagini) {
                    HttpURLConnection connection = null;
                    try {
                        URL url = new URL(link);
                        connection = (HttpURLConnection) url.openConnection();
                        InputStream is = connection.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lista = new ArrayList<>();
                lista.add(new ImaginiDomeniu("Apartament 3 camere de inchiriat Obor Bucuresti",imagini.get(0),"https://mrexclusivitate.ro/"));
                lista.add(new ImaginiDomeniu("Apartament 3 camere de vanzare Colentina Bucuresti",imagini.get(1),"https://norisk.ro/"));
                lista.add(new ImaginiDomeniu("Apartament 2 camere de vanzare Colentina Bucuresti",imagini.get(2),"https://casevechi.ro/"));
                lista.add(new ImaginiDomeniu("Apartament 3 camere de vanzare Sector 2 Bucuresti",imagini.get(3),"https://www.executarilicitatii.ro/"));
                lista.add(new ImaginiDomeniu("Apartament 3 camere de vanzare Bucur Obor Bucuresti",imagini.get(4),"https://murzea.ro/"));

                ListView lv = findViewById(R.id.imagini);
                ImagineAdapter adapter = new ImagineAdapter(lista,getApplicationContext(),R.layout.imagine_item);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });
        ListView lv = findViewById(R.id.imagini);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent it = new Intent(getApplicationContext(), WebViewActivity.class);
                //it.putExtra("link", lista.get(position).getLink());
                //startActivity(it);
            }
        });
        //adapter.notifyDataSetChanged();
    }

}