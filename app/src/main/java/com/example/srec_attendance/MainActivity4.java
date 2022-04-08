package com.example.srec_attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import java.text.SimpleDateFormat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Date;

public class MainActivity4 extends AppCompatActivity {
    private Button button4;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy");
    private long date = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener((v)->{
            MaterialDatePicker<Long> picker =
                    MaterialDatePicker.Builder.datePicker()
                            .setTitleText("Select dates")
                            .build();
            picker.show(getSupportFragmentManager(), "picker");
            picker.addOnPositiveButtonClickListener(selection -> {
                Long value = selection;
                date = value;
                Log.d("Main4", "onCreate: "+value);
                button4.setText(sdf.format(new Date(value)));
            });
        });
        Button Details = findViewById(R.id.button5);

        Details.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
            startActivity(intent);
        });

    }
}