const express = require('express'); // Biblioteca do Express
const router = express.Router(); // Gerenciador de rotas
const url = require('url'); // Ter acesso a url
const querystring = require('querystring'); // Filtrar url
const mysql = require('./mysql').pool; // Importar config do mysql

// http://localhost:3000/api.agenda/contato-dao/create
router.post('/create',(req,res,next) => {
    const { nome , fone  , email} = req.body
    const contato = { nome , fone , email}
    mysql.getConnection((error, conn) => {
        if(error){
            return res.status(500).send({
                error: error,
                response: null
            });
        }
        conn.query(
            'INSERT INTO contato (nome, fone, email) VALUES (?,?,?)',
            [contato.nome,contato.fone,contato.email],
            (error, resultado, field) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error: error,
                        response: null
                    });
                }
                res.status(201).send({ 
                    mensagem : 'Contato cadastrado com sucesso!',
                    id_contato : resultado.insertId
                });
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/getId?id=4
router.get('/getId',(req,res,next) => {
    const reqUrl = url.parse(req.url);
    const queryParams = querystring.parse(reqUrl.query);
    const param = queryParams.id;
    mysql.getConnection((error, conn) =>{
        if(error) {return res.status(500).send({error: error})}
        conn.query(
            'SELECT * FROM contato WHERE id = ?;',
            [param],
            (error, resultado, fields) =>{
                if(error) {return res.status(500).send({error: error})}
                return res.status(200).send({response : resultado})
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/getAll
router.get('/getAll',(req,res,next) => {
    mysql.getConnection((error, conn) =>{
        if(error) {return res.status(500).send({error: error})}
        conn.query(
            'SELECT * FROM contato;',
            (error, resultado, fields) =>{
                if(error) {return res.status(500).send({error: error})}
                return res.status(200).send({response : resultado})
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/updateId
router.post('/updateId',(req,res,next) => {
    const {id_contato, nome, fone, email} = req.body
    const contato = {id_contato, nome, fone, email}
    mysql.getConnection((error, conn) => {
        if(error){
            return res.status(500).send({
                error: error,
                response: null
            });
        }
        conn.query(
            'UPDATE contato SET nome =? , fone = ? , email = ? WHERE id = ?',
            [contato.nome,contato.fone,contato.email,contato.id_contato],
            (error, resultado, field) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error: error,
                        response: null
                    });
                }
                res.status(201).send({ 
                    mensagem : 'Contato atualizado',
                    "Dados contato:" : contato
                });
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/deleteId
router.post('/deleteId',(req,res,next) => {
    const {id_contato} = req.body
    const contato = {id_contato}
    mysql.getConnection((error, conn) => {
        if(error){
            return res.status(500).send({
                error: error,
                response: null
            });
        }
        conn.query(
            'DELETE FROM contato WHERE id = ?',
            [contato.id_contato],
            (error, resultado, field) => {
                conn.release();
                if(error){
                    return res.status(500).send({
                        error: error,
                        response: null
                    });
                }
                res.status(201).send({ 
                    mensagem : 'Contato excluído'
                });
            }
        )
    });
});

module.exports = router; // Exportar módulo para uso