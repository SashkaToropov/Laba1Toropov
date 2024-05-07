package com.example.laba1toropov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityPressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pressure);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculateBP(View view) {
        float age = 0;
        float weight = 0;
        double ps = 0;
        double pd = 0;

        EditText varAge=(EditText) findViewById(R.id.editAge);
        EditText varWeight=(EditText) findViewById(R.id.editWeight);
        TextView resPs=(TextView) findViewById(R.id.res_ps);
        TextView resPd=(TextView) findViewById(R.id.res_pd);

        age = Float.parseFloat(varAge.getText().toString());
        weight = Float.parseFloat(varWeight.getText().toString());

        if(age>=17) {
            ps = (float) (109 + 0.5 * age + 0.1 * weight);
            pd = (float) (63 + 0.1 * age + 0.15 * weight);
        }
        else {
            ps = (float) (83 + 1.7 * age );
            pd = (float) (42 + 1.6 * age );
        }

        resPs.setText(String.format("%.2f",ps));
        resPd.setText(String.format("%.2f",pd));
    }

    public void backMainActivity(View view) {
        Intent intent = new Intent(ActivityPressure.this, MainActivity.class);
        startActivity(intent);
    }
}