package com.professoraecio.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewIdade;
    NumberPicker numberPickerIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setupComponents();
    }

    private void setupComponents(){
        textViewIdade = findViewById(R.id.textViewIdade);
        numberPickerIdade = findViewById(R.id.numberPickerIdade);

        numberPickerIdade.setMinValue(0);
        numberPickerIdade.setMaxValue(100);

        numberPickerIdade.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textViewIdade.setText("" + i1);
            }
        });
    }
}