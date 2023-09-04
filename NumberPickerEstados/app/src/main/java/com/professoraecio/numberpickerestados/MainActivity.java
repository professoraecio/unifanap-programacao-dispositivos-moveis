package com.professoraecio.numberpickerestados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewEstado;
    NumberPicker numberPickerEstado;
    String[] estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setupComponents();
    }

    private void setupComponents(){
        textViewEstado = findViewById(R.id.textViewEstado);
        numberPickerEstado = findViewById(R.id.numberPickerEstado);
        estados = getResources().getStringArray(R.array.estados);
        numberPickerEstado.setMinValue(0);
        numberPickerEstado.setMaxValue(estados.length - 1);
        numberPickerEstado.setDisplayedValues(estados);
        numberPickerEstado.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textViewEstado.setText("" + estados[i1]);
            }
        });
    }
}