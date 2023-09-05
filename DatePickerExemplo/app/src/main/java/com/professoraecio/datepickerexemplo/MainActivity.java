package com.professoraecio.datepickerexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textViewDataEscolhida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDataEscolhida = findViewById(R.id.textViewDataEscolhida);
    }

    public void escolherDataButtonAction(View view){
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int mesAtual = calendario.get(Calendar.MONTH);
        int diaAtual = calendario.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                mes++;
                String m = mes < 10 ? "0" + mes : "" + mes;
                textViewDataEscolhida.setText("" + dia + "/" + m + "/" + ano);
            }

        },anoAtual,mesAtual,diaAtual);
        dialog.show();
    }


}