package com.example.laba1toropov;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight);
        View editAge = findViewById(R.id.editAge);
        registerForContextMenu(editAge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_weight, menu);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Spinner spinner = (Spinner) findViewById(R.id.spinner_gender);
        String selectedText= spinner.getSelectedItem().toString();
        if (id == R.id.context_menu_item1) {
            Toast.makeText(this, selectedText, Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    public void calculateWeight(View view) {
        float age = 0;
        float height = 0;
        double weight = 0;
        int gend = 0;

        EditText varAge=(EditText) findViewById(R.id.editAge);
        EditText varHeight=(EditText) findViewById(R.id.editHeight);
        TextView resWeight=(TextView) findViewById(R.id.res_weight);
        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFemale = findViewById(R.id.radioFemale);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_gender);

        age=Float.parseFloat(varAge.getText().toString());
        height=Float.parseFloat(varHeight.getText().toString());

        if (radioMale.isChecked()) {
            weight = 50 + (height - 150) * 0.75 + (age - 21) / 4;
        } else if (radioFemale.isChecked()) {
            weight = 50 + (height - 150) * 0.32 + (age - 21) / 5;
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Specify gender", Toast.LENGTH_SHORT);
            toast.show();
        }

        resWeight.setText(String.valueOf(weight));
    }

    public void backtoMainActivity(View view) {
        Intent intent = new Intent(ActivityWeight.this, MainActivity.class);
        startActivity(intent);
    }
}