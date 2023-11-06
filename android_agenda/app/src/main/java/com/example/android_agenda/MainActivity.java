package com.example.android_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android_agenda.controller.ContatoDao;
import com.example.android_agenda.http.ContatoParser;
import com.example.android_agenda.model.ContactAdapter;
import com.example.android_agenda.model.Contato;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ContactAdapter adapter;

    ArrayList<Contato> contatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ContatoDao contatoDao = new ContatoDao();
        ContatoParser contatoParser = new ContatoParser();
        String response = contatoDao.todos();
        contatos = contatoParser.getContatosFromJson(response);

        adapter = new ContactAdapter(this, contatos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contato contato = new Contato();
                contato = contatos.get(i);
                Intent intent = new Intent(MainActivity.this,ContactDetailsActivity.class);
                intent.putExtra("contato", contato);
                startActivity(intent);
            }
        });

    }

    public void adicionarContato(View view){
        Intent intent = new Intent(this,AddEditContactActivity.class);
        startActivity(intent);
    }
}