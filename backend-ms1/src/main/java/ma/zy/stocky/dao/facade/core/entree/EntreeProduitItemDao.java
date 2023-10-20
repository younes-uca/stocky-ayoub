package ma.zy.stocky.dao.facade.core.entree;

import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.entree.EntreeProduitItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EntreeProduitItemDao extends AbstractRepository<EntreeProduitItem,Long>  {

    List<EntreeProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<EntreeProduitItem> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);


}
