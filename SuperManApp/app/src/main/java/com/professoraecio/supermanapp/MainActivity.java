package com.professoraecio.supermanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] dados = {"BatMovel" , "Bat Cinto de utilidades" , "Robin" , "Pimguim" , "2 Caras" , "Mulher Gato"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_list,R.id.textView,dados);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String itemClicado = adapter.getItem(position);
                Toast.makeText(MainActivity.this,"Item clicado " + itemClicado,Toast.LENGTH_LONG).show();
            }
        });


    }
}