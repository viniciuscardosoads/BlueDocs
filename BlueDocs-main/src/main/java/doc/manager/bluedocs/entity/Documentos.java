package doc.manager.bluedocs.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_documentos")
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "documentoid")
    private UUID documentoid;

    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "os_servico")
    private String os_servico;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    // Construtor vazio obrigatório pelo JPA
    public Documentos() {}

    // Getters e setters
    public UUID getDocumentoid() { return documentoid; }
    public void setDocumentoid(UUID documentoid) { this.documentoid = documentoid; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getOs_servico() { return os_servico; }
    public void setOs_servico(String os_servico) { this.os_servico = os_servico; }

    public Instant getCreationTimestamp() { return creationTimestamp; }
    public Instant getUpdateTimestamp() { return updateTimestamp; }
}