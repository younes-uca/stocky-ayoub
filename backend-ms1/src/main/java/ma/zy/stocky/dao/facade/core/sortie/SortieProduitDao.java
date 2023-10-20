package ma.zy.stocky.dao.facade.core.sortie;

import org.springframework.data.jpa.repository.Query;
import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.sortie.SortieProduit;
import org.springframework.stereotype.Repository;
import ma.zy.stocky.bean.core.sortie.SortieProduit;
import java.util.List;


@Repository
public interface SortieProduitDao extends AbstractRepository<SortieProduit,Long>  {
    SortieProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<SortieProduit> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);

    @Query("SELECT NEW SortieProduit(item.id,item.reference) FROM SortieProduit item")
    List<SortieProduit> findAllOptimized();

}
