package ma.zy.stocky.dao.facade.core.commun;

import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.commun.Stock;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StockDao extends AbstractRepository<Stock,Long>  {

    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<Stock> findByDepotId(Long id);
    int deleteByDepotId(Long id);


}
