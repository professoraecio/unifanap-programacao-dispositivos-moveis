package com.example.android_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_agenda.controller.ContatoDao;
import com.example.android_agenda.model.Contato;

public class AddEditContactActivity extends AppCompatActivity {

    String nome,fone,email;
    EditText editTextNome;
    EditText editTextEmail;
    EditText editTextTelefone;
    Contato contato = new Contato();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_contact);
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefone = findViewById(R.id.editTextTelefone);

        Intent intent = getIntent();
        if (intent.hasExtra("contato")) {
            contato = (Contato) intent.getSerializableExtra("contato");
            editTextNome.setText(contato.getNome());
            editTextEmail.setText(contato.getEmail());
            editTextTelefone.setText(contato.getFone());
        }
    }

    public void salvar(View view){
        nome = editTextNome.getText().toString();
        fone = editTextTelefone.getText().toString();
        email = editTextEmail.getText().toString();

        contato.setNome(nome);
        contato.setFone(fone);
        contato.setEmail(email);
        ContatoDao contatoDao = new ContatoDao();
        if(contato.getId() == 0){
            String response = contatoDao.inserir(contato);
            Toast.makeText(this, response, Toast.LENGTH_LONG).show();
        }else{
            String response = contatoDao.atualizar(contato);
            Toast.makeText(this, response, Toast.LENGTH_LONG).show();
        }

    }
}