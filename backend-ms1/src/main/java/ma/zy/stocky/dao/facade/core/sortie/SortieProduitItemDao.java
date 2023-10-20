package ma.zy.stocky.dao.facade.core.sortie;

import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.sortie.SortieProduitItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SortieProduitItemDao extends AbstractRepository<SortieProduitItem,Long>  {

    List<SortieProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<SortieProduitItem> findBySortieProduitId(Long id);
    int deleteBySortieProduitId(Long id);


}
