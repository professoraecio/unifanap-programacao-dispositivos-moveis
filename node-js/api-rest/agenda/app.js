const URL_BASE = '/api.agenda'; // URL Base
const express = require('express'); // Biblioteca do Express
const app = express(); // Criando uma instância do Express
const morgan = require('morgan'); // Biblioteca do Morgan
app.use(morgan('dev')); // Usar o depurador Morgan
const bodyParser = require('body-parser'); // Biblioteca do body-parser
app.use(bodyParser.urlencoded({extended : false})); // Config body-parser
app.use(bodyParser.json()); // Config body-parser

// <rotas>

// </rotas>

// http://localhost:3000/api.agenda
app.use(URL_BASE,(req,res,next) =>{ // Rota URL Base
    res.status(200).send({
        resposta : 'URL Base da API REST funcionou!'
    });
});

app.use((req,res,next) => { // Rota não encontrada
    const erro = new Error('Rota não encontrada!');
    erro.status = 404;
    next(erro);
});

module.exports = app; // Exportar o módulo para uso