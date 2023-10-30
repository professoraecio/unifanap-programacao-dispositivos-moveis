const express = require('express'); // Biblioteca do Express
const router = express.Router(); // Gerenciador de rotas
const url = require('url'); // Ter acesso as informarções da própria URL
const queryString = require('querystring'); // Filtrar URL por query (igual ao SQL)

// http://localhost:3000/api.agenda/contato-dao/getId?id=3
router.get('/getId',(req,res,next) => {
    const reqUrl = url.parse(req.url); // pegando a minha URL
    const queryParams = queryString.parse(reqUrl.query); // pegando parâmetros da URl
    const paramId = queryParams.id; // pegando o parâmetro id
    res.status(200).send({
        mensagem : 'Contato encontrado! >> id = ' + paramId
    });
});

// http://localhost:3000/api.agenda/contato-dao/getAll
router.get('/getAll',(req,res,next) => {
    res.status(200).send({
        mensagem : 'Contatos encontrados!'
    });
});

// http://localhost:3000/api.agenda/contato-dao/updateId
/*
{
    "id_contato" : 3,
    "nome" : "João123",
    "fone" : "(62) 99999-9999",
    "email" : "joao123@gmail.com"
}
*/
router.post('/updateId',(req,res,next) => {
    const {id_contato, nome , fone , email} = req.body
    const contato = {id_contato, nome , fone , email}
    res.status(201).send({
        mensagem : 'Contato atualizado!',
        "Dados contato: " : contato
    });
});

// http://localhost:3000/api.agenda/contato-dao/deleteId
/*
{
    "id_contato" : 3
}
*/
router.post('/deleteId',(req,res,next) => {
    const {id_contato} = req.body
    const contato = {id_contato}
    res.status(200).send({
        mensagem : 'Contato excluído! >> id = ' + contato.id_contato
    });
});

// http://localhost:3000/api.agenda/contato-dao/create
/*
{
    "nome" : "João123",
    "fone" : "(62) 99999-9999",
    "email" : "joao123@gmail.com"
}
*/
router.post('/create',(req,res,next) => {
    const {nome , fone , email} = req.body
    const contato = {nome , fone , email}
    res.status(201).send({
        mensagem : 'Contato criado!',
        "Dados contato: " : contato
    });
});

module.exports = router; // Exportar módulo para uso no servidor