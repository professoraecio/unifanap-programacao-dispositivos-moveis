const express = require('express'); // Biblioteca do Express
const router = express.Router(); // Gerenciador de rotas

// http://localhost:3000/api.agenda/contato-dao/getId
router.get('/getId',(req,res,next) => {
    res.status(200).send({
        mensagem : 'Contato encontrado!'
    });
});

// http://localhost:3000/api.agenda/contato-dao/getAll
router.get('/getAll',(req,res,next) => {
    res.status(200).send({
        mensagem : 'Contatos encontrados!'
    });
});

// http://localhost:3000/api.agenda/contato-dao/updateId
router.get('/updateId',(req,res,next) => {
    res.status(200).send({
        mensagem : 'Contato atualizado!'
    });
});

// http://localhost:3000/api.agenda/contato-dao/deleteId
router.get('/deleteId',(req,res,next) => {
    res.status(200).send({
        mensagem : 'Contato excluído!'
    });
});

// http://localhost:3000/api.agenda/contato-dao/create
router.get('/create',(req,res,next) => {
    res.status(200).send({
        mensagem : 'Contato criado!'
    });
});

module.exports = router; // Exportar módulo para uso