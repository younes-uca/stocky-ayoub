package ma.zy.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zy.stocky.bean.core.entree.EntreeProduitItem;
import ma.zy.stocky.dao.criteria.core.entree.EntreeProduitItemCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface EntreeProduitItemAdminService extends  IService<EntreeProduitItem,EntreeProduitItemCriteria>  {

    List<EntreeProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<EntreeProduitItem> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);



}
