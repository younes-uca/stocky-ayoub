package ma.zy.stocky.dao.facade.core.entree;

import org.springframework.data.jpa.repository.Query;
import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.entree.EntreeProduit;
import org.springframework.stereotype.Repository;
import ma.zy.stocky.bean.core.entree.EntreeProduit;
import java.util.List;


@Repository
public interface EntreeProduitDao extends AbstractRepository<EntreeProduit,Long>  {
    EntreeProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    List<EntreeProduit> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);

    @Query("SELECT NEW EntreeProduit(item.id,item.reference) FROM EntreeProduit item")
    List<EntreeProduit> findAllOptimized();

}
