Readme A3 
Conectar o Docker com o Mysql através da classe dockercompose.yml

Dados do Host
services:
  mysql:
    image: 'mysql:latest'
    environment:
      - MYSQL_DATABASE=bluedocs
      - MYSQL_USER=myuser
      - MYSQL_PASSWORD=secret
      - MYSQL_ROOT_PASSWORD=Samuel080786
    ports:
      - "3306:3306"
    volumes:
      - "./conf.d:/etc/mysql/conf.d:ro"

° Realização de requisições
- Cria ambiente no Postman
- Usar LocalHost: http://localhost:8080/v1/documents
- Executar requisições: POST, GET, DELETE, PUT

° Comando para execução no campo "Body" do Postman
{
  "tipoDocumento": "inserir dados",
  "cliente": "inserir dados",
  "os_servico": "inserir dados"
}
