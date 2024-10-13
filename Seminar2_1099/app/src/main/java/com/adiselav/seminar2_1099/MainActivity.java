package com.adiselav.seminar2_1099;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activitate", "onStart");
        Log.w("Activitate","Warning");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activitate", "onResume");
        Log.w("Activitate","Warning");
        Toast.makeText(this, R.string.mesaj,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activitate", "onPause");
        Log.w("Activitate","Warning");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Activitate", "onStop");
        Log.w("Activitate","Warning");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Activitate", "onDestroy");
        Log.w("Activitate","Warning");
    }
}