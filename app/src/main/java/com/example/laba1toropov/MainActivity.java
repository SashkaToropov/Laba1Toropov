package com.example.laba1toropov;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openActivityPressure(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityPressure.class);
        startActivity(intent);
    }

    public void openActivityWeight(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityWeight.class);
        startActivity(intent);
    }

    public void closeApp(View view) {
        this.finishAffinity();
    }

    public void ActivityPressure_openFromMenu(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ActivityPressure.class);
        startActivity(intent);
    }

    public void ActivityWeight_openFromMenu(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ActivityWeight.class);
        startActivity(intent);
    }
    public void exitFromApp(MenuItem item) {
        this.finishAffinity();
    }
}