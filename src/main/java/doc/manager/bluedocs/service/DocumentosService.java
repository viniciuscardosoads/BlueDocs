package doc.manager.bluedocs.service;

import doc.manager.bluedocs.controller.CreateDocumentsDto;
import doc.manager.bluedocs.controller.UpdateDocumentoDto;
import doc.manager.bluedocs.entity.Documentos;
import doc.manager.bluedocs.repository.DocumentsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentosService {

    private final DocumentsRepository documentsRepository;

    public DocumentosService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    public UUID createDocumentos(CreateDocumentsDto createDocumentsDto) {
        Documentos entity = new Documentos(
                UUID.randomUUID(),
                createDocumentsDto.cliente(),
                createDocumentsDto.os_servico(),
                createDocumentsDto.tipoDocumento(),
                Instant.now(),
                null);

        Documentos documentosSave = documentsRepository.save(entity);
        return documentosSave.getDocumentoid();
    }

    // FUNÇÃO PARA INSERIR

    public Optional<Documentos> getDocumentos(String documentoid) {
        return documentsRepository.findById(UUID.fromString(documentoid));
    }

    // FUNÇÃO PARA LISTAR

    public List<Documentos> listDocumentos() {
        return documentsRepository.findAll();
    }

    // FUNÇÃO PARA DELETAR

    public void deleteById(String documentoid) {
        UUID id = UUID.fromString(documentoid);
        documentsRepository.deleteById(id);
    }

    // FUNÇÃO PARA EDITAR
    public void updateDocumentoById(String documentoid,
                                    UpdateDocumentoDto updateDocumentoDto) {
        var id = UUID.fromString(documentoid);

        var documentooExiste = documentsRepository.findById(UUID.fromString(documentoid));
        if (documentooExiste.isPresent()) {
            var documentos = documentooExiste.get();
            if (updateDocumentoDto.tipoDocumento() != null) {
                documentos.setDocumentoid(UUID.fromString(updateDocumentoDto.tipoDocumento()));
            }
        }

    }
}
