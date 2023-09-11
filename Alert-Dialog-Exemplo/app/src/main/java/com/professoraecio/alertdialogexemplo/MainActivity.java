package com.professoraecio.alertdialogexemplo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void perguntar(View view){
        // Criar a caixa de diálogo (Alert Dialog)
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        // Definir o título que vai na caixa
        alertDialog.setTitle("Atenção!");
        // Definir o texto que vai na caixa
        alertDialog.setMessage("Deseja realmente finalizar o cadastro?");
        // Configurar botão sim
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("debug-mode","Usuário clicou em sim...");
            }
        });
        // Configurar botão cancelar
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("debug-mode","Usuário clicou em cancelar...");
            }
        });
        // Criar a janela efetivamente
        AlertDialog janela = alertDialog.create();
        // Mostrar a janela
        janela.show();

    }

}