package com.professoraecio.timepickerexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView textViewHoraEscolhida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewHoraEscolhida = findViewById(R.id.textViewHoraEscolhida);
    }

    public void escolherHora(View view){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
                textViewHoraEscolhida.setText("" + hora + ":" + minuto);
            }
        },15,90,true);
        timePickerDialog.show();
    }
}