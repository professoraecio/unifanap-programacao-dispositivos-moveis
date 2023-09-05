package com.professoraecio.datepickerexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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

                Date dt = new Date(ano, mes, dia);

                Calendar cal = Calendar.getInstance();
                cal.setTime(dt);

                int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
                diaSemana--;

                mes++;
                String diaSemanaString = "";
                switch (diaSemana){
                    case 1:
                        diaSemanaString = "Domingo";
                        break;
                    case 2:
                        diaSemanaString = "Segunda";
                        break;
                    case 3:
                        diaSemanaString = "Terça";
                        break;
                    case 4:
                        diaSemanaString = "Quarta";
                        break;
                    case 5:
                        diaSemanaString = "Quinta";
                        break;
                    case 6:
                        diaSemanaString = "Sexta";
                        break;
                    case 7:
                        diaSemanaString = "Sábado";
                        break;

                }
                String m = mes < 10 ? "0" + mes : "" + mes;
                textViewDataEscolhida.setText("" + dia + "/" + m + "/" + ano + " " + diaSemanaString);
            }

        },anoAtual,mesAtual,diaAtual);
        dialog.show();
    }


}