const http = require('http'); // Importar lib http
const app = require('./app'); // Importar arquivo app.js
const port = process.env.port || 3000; // Config escutar porta
const server = http.createServer(app); // Criando servidor
server.listen(port); // Escutar porta