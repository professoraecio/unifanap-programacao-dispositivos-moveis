// Importar a biblioteca do http
const http = require('http');
// Incluir o arquivo app.js no server (servidor)
const app = require('./app');
// Configurar a porta do servidor
const port = process.env.PORT || 3000;
// Criar o servidor com o app incluso
const server = http.createServer(app);
// Servidor escutar porta
server.listen(port);