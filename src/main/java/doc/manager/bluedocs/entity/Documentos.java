// Anotation para indicar ao spring criar e utlizar esta
// classe como referências para uma tabela no banco de dados.

package doc.manager.bluedocs.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_documentos") // CRIAÇÃO DA TABELA DOCUMENTOS.

public class Documentos {

    public static boolean isPresent;
    @Id // ATRIBUTO IDENTIFICADOR NO BANCO DE DADOS, UMA PRIMAY KEY DA TABELA.


    // DEFINIR O NOME DAS COLUNAS:
    // NOME DA COLUNA ID.
    @Column(name = "Documento_ID")

    // CRIAÇÃO DA COLUNA DE ID.
    @GeneratedValue(strategy = GenerationType.UUID) // FAZ COM QUE A CADA INSERÇÃO O IDE PREENCHA AUTOMATICAMENTE.
    private UUID documentoid;

    // NOME DA COLUNA TIPO DE DOCUMENTO.
    @Column(name = "tipoDocumento")

    // CRIAÇÃO DA COLUNA DE TIPO DE DOCUMENTO.
    private String tipoDocumento;


    // NOME DA COLUNA CLIENTE.
    @Column(name = "Cliente")

    // CRIAÇÃO DA COLUNA DE CLIENTE.
    private String cliente;

    // NOME DA COLUNA OS.
    @Column(name = "OS")

    // CRIAÇÃO DA COLUNA DE OS.
    private String os_servico;


    // AO CRIAR OU ATUALIZAR ENTIDADE IRÁ PREENCHER SOZINHO.
    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    // CONSTRUTOR VAZIO
    public Documentos(UUID uuid, String cliente, String s, Instant now, Object o) {
    }

    //CONSTRUTORES
    public Documentos(UUID documentoid, String cliente,String tipoDocumento, String os_servico, Instant creationTimestamp, Instant updateTimestamp) {
        this.documentoid = documentoid;
        this.cliente = cliente;
        this.tipoDocumento = tipoDocumento;
        this.os_servico = os_servico;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }


    //GETTERS E SETTERS PARA GERENCIAMENTO DA ENTIDADE
    public UUID getDocumentoid() {
        return documentoid;
    }

    public void setDocumentoid(UUID documentoid) {
        this.documentoid = documentoid;
    }

    public String getCliente() {
        return cliente;
    }

    public String gettipoDocumento() {
        return tipoDocumento;
    }



    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getOs_servico() {
        return os_servico;
    }

    public void setOs_servico(String os_servico) {
        this.os_servico = os_servico;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
