package ma.zy.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.commun.CategorieProduit;
import org.springframework.stereotype.Repository;
import ma.zy.stocky.bean.core.commun.CategorieProduit;
import java.util.List;


@Repository
public interface CategorieProduitDao extends AbstractRepository<CategorieProduit,Long>  {
    CategorieProduit findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW CategorieProduit(item.id,item.reference) FROM CategorieProduit item")
    List<CategorieProduit> findAllOptimized();

}
