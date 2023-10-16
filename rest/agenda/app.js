// URL Base da aplicação
const URL_BASE = '/api.agenda';
// Usar a biblioteca do express
const express = require('express');
// Instanciar o express
const app = express();

// Corpo do código fonte o projeto

// Criar uma resposta para
// URL padrão do servidor
/*
app.use((req,res,next) =>{
    res.status(200).send({
        resposta : 'Servidor respondeu!'
    });
});
*/

app.use(URL_BASE,(req,res,next) =>{
    res.status(200).send({
        resposta : 'Servidor respondeu na URL BASE!'
    });
});


// Fim corpo do código fonte o projeto

// Fazendo o link da biblioteca
// express com o projeto
// Ligando a ferramenta com o projeto
module.exports = app;