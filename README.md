📘 BlueDocs – Sistema de Gerenciamento de Documentos de Engenharia

BlueDocs é uma aplicação Java Spring Boot integrada ao MySQL via Docker, criada para facilitar o cadastro, edição, consulta e exclusão de documentos de engenharia.

Este projeto surgiu como uma solução simplificada para substituir o fluxo complexo do software GreenDocs (W3K), utilizado pela empresa Delp Engenharia Mecânica S.A.
Devido ao alto nível de customizações solicitadas pela Delp, o GreenDocs tornou-se um sistema difícil de atualizar e com navegação pouco otimizada. O BlueDocs busca oferecer:

🔹 Simplicidade

🔹 Rapidez na consulta

🔹 Organização clara dos documentos

🔹 Fácil manutenção

🔹 API leve e eficiente

O sistema permite organizar documentos por ID, tipo de documento (DESENHO, IEIS, etc), cliente (Petrobras, Equinor, Subsea7, Hisep...) e OS de serviço.

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

MySQL

Docker + Docker Compose

Postman para testes

UUID como chave primária

🗂 Funcionalidades do Sistema

✔ Cadastrar documentos de engenharia

✔ Buscar documentos por ID

✔ Listar todos os documentos

✔ Atualizar documentos

✔ Deletar documentos

✔ Organização por tipo, OS de serviço e cliente

📦 Estrutura da Aplicação

A classe responsável pela inicialização do sistema é:

BluedocsApplication.java

🐳 Subindo o Banco de Dados com Docker

Certifique-se de ter Docker instalado na máquina.

Baixe o projeto

Abra o terminal

Navegue até a pasta do projeto

Execute:

docker-compose up


Aguarde a subida do container MySQL

Verifique se a tabela documentos foi criada corretamente

▶ Como Executar a Aplicação

Execute diretamente pela classe:

BluedocsApplication


Ou via terminal (caso use Maven):

mvn spring-boot:run

🧪 Testando a API no Postman

Crie um ambiente com requisições:

GET → Consultar documentos

POST → Criar documentos

PUT → Atualizar documentos

DELETE → Deletar documentos

URL base:

http://localhost:8080/v1/documents

📥 POST – Criar Documento

Exemplo de requisição:

{
  "tipoDocumento": "DESENHO",
  "os_servico": "7931",
  "cliente": "PETROBRAS"
}


Esse exemplo cadastra um documento do tipo DESENHO da Petrobras, associado à OS 7931.

📤 GET – Consultar Documentos

Para buscar todos:

GET http://localhost:8080/v1/documents

❌ DELETE – Excluir Documento por ID

Exemplo de ID gerado no POST:

c8c4f932-c63b-42ab-9934-d59120aba35b


Então a requisição será:

DELETE http://localhost:8080/v1/documents/c8c4f932-c63b-42ab-9934-d59120aba35b


O documento correspondente será removido.

✏ PUT – Atualizar Documento

Exemplo cadastrado inicialmente:

{
  "tipoDocumento": "IEIS",
  "os_servico": "7931",
  "cliente": "HISEP"
}


Para atualizar, envie novamente o corpo alterado:

{
  "tipoDocumento": "IEIS-revisada",
  "os_servico": "7931",
  "cliente": "HISEP"
}


Com o ID da atualização:

PUT http://localhost:8080/v1/documents/83f0f2dc-2710-43e6-bd83-ac79ac6f803f


Após executar, consulte via GET para confirmar a alteração.

🧾 Sobre o Projeto

O BlueDocs é uma solução desenvolvida para simplificar o gerenciamento de documentos de engenharia, trazendo:

Organização intuitiva

Facilidade de consulta

Redução de etapas para localizar documentos

Tecnologia moderna e de fácil manutenção

Ótima alternativa ao fluxo complexo do GreenDocs

👨‍💻 Desenvolvedores

Islan Samuel

Viníciu Gonçalves

Matheus Fellipe Tomé

Saulo Inácio
