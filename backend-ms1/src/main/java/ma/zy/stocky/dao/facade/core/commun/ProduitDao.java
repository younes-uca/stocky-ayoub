package ma.zy.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.commun.Produit;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProduitDao extends AbstractRepository<Produit,Long>  {

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);

    @Query("SELECT NEW Produit(item.id,item.reference) FROM Produit item")
    List<Produit> findAllOptimized();

}
