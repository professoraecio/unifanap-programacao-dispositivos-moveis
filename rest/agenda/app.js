// URL Base da aplicação
const URL_BASE = '/api.agenda';
// Usar a biblioteca do express
const express = require('express');
// Instanciar o express
const app = express();
// Instanciar o depurador morgan (debug no código)
const morgan = require('morgan');
app.use(morgan('dev'));
// Instanciar o body parser
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended : false}));
app.use(bodyParser.json());

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

// Mapear a pasta routes com suas rotas
// específicas nos arquivos (antes da URL padrão)

const contatoDao = require('./routes/contatoDao');
app.use('/api.agenda/contato',contatoDao);


app.use(URL_BASE,(req,res,next) =>{
    res.status(200).send({
        resposta : 'Servidor respondeu na URL BASE! Oba'
    });
});

// Tratamento de rota não encontrada
app.use((req,res,next) =>{
    const erro = new Error('Rota não encontrada');
    erro.status = 404;
    next(erro);
});



// Fim corpo do código fonte o projeto

// Fazendo o link da biblioteca
// express com o projeto
// Ligando a ferramenta com o projeto
module.exports = app;