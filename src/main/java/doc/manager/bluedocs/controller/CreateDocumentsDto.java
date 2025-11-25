// CLASSE PARA CRIAÇÃO DE DTOS
// NESSA CLASSE É POSSÍVEL DEFINIR OS CAMPOS QUE SERÃO RECEBIDOS NA REQUISIÇÃO
// NO MOMENTO DE CADASTRAR O DOCUMENTO.

package doc.manager.bluedocs.controller;

public record CreateDocumentsDto(String tipoDocumento, String cliente, String os_servico) {
}
