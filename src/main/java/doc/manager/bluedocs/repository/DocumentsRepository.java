// CLASSE PARA QUE O SPRING SE CONECTE AO BANCO DE DADOS.

package doc.manager.bluedocs.repository;

import doc.manager.bluedocs.entity.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;


@Repository // DESSA FORMA O SPRING VAI ENTENDER E CRIAR UMA IMPLEMENTAÇÃO EM TEMPO DE RUN TIME.
public interface DocumentsRepository extends JpaRepository<Documentos, UUID> {
}
