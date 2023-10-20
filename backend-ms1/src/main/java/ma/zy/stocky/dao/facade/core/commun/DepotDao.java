package ma.zy.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.commun.Depot;
import org.springframework.stereotype.Repository;
import ma.zy.stocky.bean.core.commun.Depot;
import java.util.List;


@Repository
public interface DepotDao extends AbstractRepository<Depot,Long>  {
    Depot findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW Depot(item.id,item.libelle) FROM Depot item")
    List<Depot> findAllOptimized();

}
