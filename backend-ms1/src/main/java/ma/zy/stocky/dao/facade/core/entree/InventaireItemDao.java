package ma.zy.stocky.dao.facade.core.entree;

import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.entree.InventaireItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InventaireItemDao extends AbstractRepository<InventaireItem,Long>  {

    List<InventaireItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<InventaireItem> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);


}
