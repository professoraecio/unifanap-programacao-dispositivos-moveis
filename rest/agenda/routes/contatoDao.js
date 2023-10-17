const express = require('express');
const router = express.Router();

// http://localhost:3000/api.agenda/contato/inserir
router.post('/inserir',(req,res,next) =>{
    const {nome,fone} = req.body
    const contato = {nome,fone}
    res.status(201).send({
        mensagem : 'Contato inserido',
        contato : contato
    });
});

// http://localhost:3000/api.agenda/contato/todos
router.get('/todos',(req,res,next) =>{
    res.status(200).send({
        mensagem : 'Listagem contatos'
    });
});

// http://localhost:3000/api.agenda/contato/getId
router.get('/getId',(req,res,next) =>{
    res.status(200).send({
        mensagem : 'Buscar contato'
    });
});

// http://localhost:3000/api.agenda/contato/updateId
router.get('/updateId',(req,res,next) =>{
    res.status(200).send({
        mensagem : 'Atualizar contato'
    });
});

// http://localhost:3000/api.agenda/contato/excluirId
router.get('/excluirId',(req,res,next) =>{
    res.status(200).send({
        mensagem : 'Excluir contato'
    });
});

module.exports = router;