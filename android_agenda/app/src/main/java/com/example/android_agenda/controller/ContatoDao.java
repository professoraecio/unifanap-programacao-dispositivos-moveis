package com.example.android_agenda.controller;

import com.example.android_agenda.http.HttpHelper;
import com.example.android_agenda.model.Contato;
import com.example.android_agenda.model.ContatoAtualizar;
import com.example.android_agenda.model.ContatoExcluir;
import com.google.gson.Gson;

public class ContatoDao {

    public String toJson(Contato contato){
        Gson gson = new Gson();
        String contatoJson = gson.toJson(contato);
        return contatoJson;
    }
    public String toJsonExcluir(ContatoExcluir contatoExcluir){
        Gson gson = new Gson();
        String contatoJson = gson.toJson(contatoExcluir);
        return contatoJson;
    }

    public String toJsonAtualizar(ContatoAtualizar contatoAtualizar){
        Gson gson = new Gson();
        String contatoJson = gson.toJson(contatoAtualizar);
        return contatoJson;
    }
    // http://172.20.10.5:3000/api.agenda/contato-dao/create
    public String inserir(Contato contato){
        String contatoJson = this.toJson(contato);
        HttpHelper httpHelper = new HttpHelper();
        String response = httpHelper.post(contatoJson,"/api.agenda/contato-dao/create");
        return response;
    }
    // http://172.20.10.5:3000/api.agenda/contato-dao/getId?id=4
    public String buscar(Contato contato){
        HttpHelper httpHelper = new HttpHelper();
        String response = httpHelper.get("/api.agenda/contato-dao/getId?id=" + contato.getId());
        return response;
    }
    // http://172.20.10.5:3000/api.agenda/contato-dao/getAll
    public String todos(){
        HttpHelper httpHelper = new HttpHelper();
        String response = httpHelper.get("/api.agenda/contato-dao/getAll");
        return response;
    }
    // http://172.20.10.5:3000/api.agenda/contato-dao/updateId
    public String atualizar(Contato contato){
        ContatoAtualizar contatoAtualizar = new ContatoAtualizar();
        contatoAtualizar.setId_contato(contato.getId());
        contatoAtualizar.setNome(contato.getNome());
        contatoAtualizar.setFone(contato.getFone());
        contatoAtualizar.setEmail(contato.getEmail());
        String contatoJson = this.toJsonAtualizar(contatoAtualizar);
        HttpHelper httpHelper = new HttpHelper();
        String response = httpHelper.post(contatoJson,"/api.agenda/contato-dao/updateId");
        return response;
    }
    // http://localhost:3000/api.agenda/contato-dao/deleteId
    public String excluir(Contato contato){
        ContatoExcluir contatoExcluir = new ContatoExcluir();
        contatoExcluir.setId_contato(contato.getId());
        String contatoJson = this.toJsonExcluir(contatoExcluir);
        HttpHelper httpHelper = new HttpHelper();
        String response = httpHelper.post(contatoJson,"/api.agenda/contato-dao/deleteId");
        return response;
    }

}
