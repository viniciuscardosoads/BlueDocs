
//CLASSE CONTROLLER É A PORTA DE ENTRADA DO PROJETO, É RESPONSÁVEL POR  CHAMAR
// A CLASSE "DOCUMENTOSSERVICE" E O BANCO DE DADOS
package doc.manager.bluedocs.controller;


// SPRING IRÁ ENTENDER QUE TUDO QUE SERÁ DEFINIDO NESSA CLASSE SERÁ UM ENDPOINT NA API.

import doc.manager.bluedocs.entity.Documentos;
import doc.manager.bluedocs.service.DocumentosService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController // SPRING IRÁ ENTENDER QUE TUDO QUE SERÁ DEFINIDO NESSA CLASSE SERÁ UM ENDPOINT NA API.

// DEFINIR O CAMINHO DA URL PARA CHEGAR NA API.
@RequestMapping("/v1/documents")
public class documentosController {

    private final DocumentosService documentosService;

    // INJETAR DENTRO DO CONSTRUTOR


    public documentosController(DocumentosService documentosService) {
        this.documentosService = documentosService;
    }

    @PostMapping
    public ResponseEntity<Void> createDocuments(@RequestBody CreateDocumentsDto dto) {
        var documentoid = documentosService.createDocumentos(dto);
        return ResponseEntity.created(URI.create("/v1/documents/" + documentoid)).build();
    }


    //FUNCIONALIDADE PARA INSERIR USUÁRIOS SE COMOMUNICA COM A CLASSE "DocumentosService"
    @GetMapping("/{documentoid}")
    public ResponseEntity<Documentos> getById(@PathVariable String documentoid) {
        var documentos = documentosService.getDocumentos(documentoid);

        if (documentos.isPresent()) {
            return ResponseEntity.ok(documentos.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //FUNCIONALIDADE PARA CONSULTAR USUÁRIOS, SE COMOMUNICA COM A CLASSE "DocumentosService".
    @GetMapping
    public ResponseEntity<List<Documentos>> list() {
        return ResponseEntity.ok(documentosService.listDocumentos());
    }

    //FUNCIONALIDADE PARA EDITAR DOCUMENTOS
    @PutMapping("/{documentoid}")
    public ResponseEntity<Void> update(@PathVariable String documentoid,
                                       @RequestBody UpdateDocumentoDto dto) {
        documentosService.updateDocumentoById(documentoid, dto);
        return ResponseEntity.noContent().build();
    }




    //FUNCIONALIDADE PARA EXCLUIR

    @DeleteMapping("/{documentoid}")
    public ResponseEntity<Void> delete(@PathVariable String documentoid) {
        documentosService.deleteById(documentoid);
        return ResponseEntity.noContent().build();
    }
}
