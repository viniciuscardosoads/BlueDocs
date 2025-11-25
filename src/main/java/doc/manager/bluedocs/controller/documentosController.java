
//CLASSE CONTROLLER É A PORTA DE ENTRADA DO PROJETO, É RESPONSÁVEL POR  CHAMAR
// A CLASSE "DOCUMENTOSSERVICE" E O BANCO DE DADOS
package doc.manager.bluedocs.controller;


// SPRING IRÁ ENTENDER QUE TUDO QUE SERÁ DEFINIDO NESSA CLASSE SERÁ UM ENDPOINT NA API.

import doc.manager.bluedocs.entity.Documentos;
import doc.manager.bluedocs.service.DocumentosService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController // SPRING IRÁ ENTENDER QUE TUDO QUE SERÁ DEFINIDO NESSA CLASSE SERÁ UM ENDPOINT NA API.

// DEFINIR O CAMINHO DA URL PARA CHEGAR NA API.
@RequestMapping("/v1/documents")
public class documentosController {

    private DocumentosService documentosService;

    // INJETAR DENTRO DO CONSTRUTOR


    public documentosController(DocumentosService documentosService) {
        this.documentosService = documentosService;
    }

    @PostMapping
    public ResponseEntity<User> createDocuments(@RequestBody CreateDocumentsDto CreateDocumentsDto) {
        documentosService.createDocumentos(CreateDocumentsDto);
        var documentoid = documentosService.createDocumentos(CreateDocumentsDto);
        return ResponseEntity.created(URI.create("/v1/documents/" + documentoid.toString())).build();
    }



    //FUNCIONALIDADE PARA INSERIR USUÁRIOS SE COMOMUNICA COM A CLASSE "DocumentosService"
    @GetMapping("/{DocumentsID}")
    public ResponseEntity<Documentos> getdocumentsbById(@PathVariable("DocumentsID") String documentsID) {
        var documentos = documentosService.getDocumentos(documentsID);
        if (Documentos.isPresent){
            return ResponseEntity.ok(documentos.get());

        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //FUNCIONALIDADE PARA CONSULTAR USUÁRIOS, SE COMOMUNICA COM A CLASSE "DocumentosService".
    @GetMapping
    public ResponseEntity<List<Documentos>> listDocumentos() {
        var documentos = documentosService.listDocumentos();
        return ResponseEntity.ok(documentos);

    }
    //FUNCIONALIDADE PARA EDITAR DOCUMENTOS
    @PutMapping("/{DocumentsID}")
    public ResponseEntity<Void> updateDocumentoById(@PathVariable("documentoid") String documentoid,
                                                    @RequestBody UpdateDocumentoDto UpdateDocumentoDto) {
        documentosService.updateDocumentoById(documentoid, UpdateDocumentoDto);
        return ResponseEntity.noContent().build();

    }




    //FUNCIONALIDADE PARA EXCLUIR

    @DeleteMapping("/{DocumentsID}")
    public ResponseEntity<Void> deleteById(@PathVariable("documentoid") String documentoid) {
        documentosService.deleteById(documentoid);
        return ResponseEntity.noContent().build();




    }

}
