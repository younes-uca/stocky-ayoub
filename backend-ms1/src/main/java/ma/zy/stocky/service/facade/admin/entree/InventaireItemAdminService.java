package ma.zy.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zy.stocky.bean.core.entree.InventaireItem;
import ma.zy.stocky.dao.criteria.core.entree.InventaireItemCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface InventaireItemAdminService extends  IService<InventaireItem,InventaireItemCriteria>  {

    List<InventaireItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<InventaireItem> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);



}
