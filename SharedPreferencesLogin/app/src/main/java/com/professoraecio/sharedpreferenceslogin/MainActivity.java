package com.professoraecio.sharedpreferenceslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsuario;
    EditText editTextSenha;
    CheckBox checkboxMemorizarSenha;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setupComponents();
    }

    private void setupComponents(){
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenha = findViewById(R.id.editTextSenha);
        //View checkBoxMemorizarSenha = findViewById(R.id.checkboxMemorizarSenha);
        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        String credenciaisSalvas = sharedPreferences.getString("credenciaisSalvas","");
        if(credenciaisSalvas.equalsIgnoreCase("sim")){
            String usuario = sharedPreferences.getString("usuario","");
            String senha = sharedPreferences.getString("senha","");
            editTextUsuario.setText(usuario);
            editTextSenha.setText(senha);
        }
    }

    public void entrar(View view){
        String usuario = editTextUsuario.getText().toString();
        String senha = editTextSenha.getText().toString();
        if(usuario.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("credenciaisSalvas","sim");
            editor.putString("usuario",usuario);
            editor.putString("senha",senha);
            editor.apply();
            Toast.makeText(this,"Salvou usuario e senha",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"usuario e senha invalido",Toast.LENGTH_SHORT).show();
        }
    }
}