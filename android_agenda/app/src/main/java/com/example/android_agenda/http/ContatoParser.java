package com.example.android_agenda.http;
import com.example.android_agenda.model.Contato;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContatoParser {
    public Contato getContatoFromJson(String jsonString){
        Contato contato = new Contato();
        try {
            // Converter a string para um objeto JSON
            JSONObject jsonObject = new JSONObject(jsonString);
            // Extrair informações de contato do objeto JSON
            JSONArray contacts = jsonObject.getJSONArray("response");
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject contact = contacts.getJSONObject(i);
                String nome = contact.getString("nome");
                String email = contact.getString("email");
                String fone = contact.getString("fone");
                int id = contact.getInt("id");
                contato.setId(id);
                contato.setNome(nome);
                contato.setFone(fone);
                contato.setEmail(email);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contato;
    }
    public ArrayList<Contato> getContatosFromJson(String jsonString){
        Contato contato = new Contato();
        ArrayList<Contato> contatos = new ArrayList<>();
        try {
            // Converter a string para um objeto JSON
            JSONObject jsonObject = new JSONObject(jsonString);
            // Extrair informações de contato do objeto JSON
            JSONArray contacts = jsonObject.getJSONArray("response");
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject contact = contacts.getJSONObject(i);
                String nome = contact.getString("nome");
                String email = contact.getString("email");
                String fone = contact.getString("fone");
                int id = contact.getInt("id");
                contato = new Contato();
                contato.setId(id);
                contato.setNome(nome);
                contato.setFone(fone);
                contato.setEmail(email);
                contatos.add(contato);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contatos;
    }
}
