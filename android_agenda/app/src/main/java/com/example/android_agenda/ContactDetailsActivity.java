package com.example.android_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_agenda.controller.ContatoDao;
import com.example.android_agenda.model.Contato;

public class ContactDetailsActivity extends AppCompatActivity {

    String nome,fone,email;
    TextView textViewNome;
    TextView textViewEmail;
    TextView textViewTelefone;
    Contato contato = new Contato();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        textViewNome = findViewById(R.id.textViewNome);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewTelefone = findViewById(R.id.textViewTelefone);

        Intent intent = getIntent();
        if (intent.hasExtra("contato")) {
            contato = (Contato) intent.getSerializableExtra("contato");
            textViewNome.setText(contato.getNome());
            textViewEmail.setText(contato.getEmail());
            textViewTelefone.setText(contato.getFone());
        }
    }

    public void editar(View view){
        Intent intent = new Intent(this,AddEditContactActivity.class);
        intent.putExtra("contato", contato);
        startActivity(intent);
    }

    public void excluir(View view){
        ContatoDao contatoDao = new ContatoDao();
        String response = contatoDao.excluir(contato);
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}