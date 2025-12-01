package doc.manager.bluedocs.service;

import doc.manager.bluedocs.controller.CreateDocumentsDto;
import doc.manager.bluedocs.controller.UpdateDocumentoDto;
import doc.manager.bluedocs.entity.Documentos;
import doc.manager.bluedocs.repository.DocumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentosService {

    private final DocumentsRepository documentsRepository;

    public DocumentosService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    // ================== CREATE ==================
    public UUID createDocumentos(CreateDocumentsDto dto) {

        Documentos entity = new Documentos();

        entity.setTipoDocumento(dto.tipoDocumento());
        entity.setCliente(dto.cliente());
        entity.setOs_servico(dto.os_servico());

        Documentos saved = documentsRepository.save(entity);
        return saved.getDocumentoid();
    }

    // ================== GET BY ID ==================
    public Optional<Documentos> getDocumentos(String documentoid) {
        return documentsRepository.findById(UUID.fromString(documentoid));
    }

    // ================== LIST ==================
    public List<Documentos> listDocumentos() {
        return documentsRepository.findAll();
    }

    // ================== DELETE ==================
    public void deleteById(String documentoid) {
        documentsRepository.deleteById(UUID.fromString(documentoid));
    }

    // ================== UPDATE ==================
    public void updateDocumentoById(String documentoid, UpdateDocumentoDto dto) {

        var entity = documentsRepository.findById(UUID.fromString(documentoid));

        if (entity.isPresent()) {
            var doc = entity.get();

            if (dto.tipoDocumento() != null) {
                doc.setTipoDocumento(dto.tipoDocumento());
            }

            if (dto.os_servico() != null) {
                doc.setOs_servico(dto.os_servico());
            }

            if (dto.cliente() != null) {
                doc.setCliente(dto.cliente());
            }

            documentsRepository.save(doc);
        }
    }
}