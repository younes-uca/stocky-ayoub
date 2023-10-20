package ma.zy.stocky.service.facade.admin.sortie;

import java.util.List;
import ma.zy.stocky.bean.core.sortie.SortieProduitItem;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitItemCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface SortieProduitItemAdminService extends  IService<SortieProduitItem,SortieProduitItemCriteria>  {

    List<SortieProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<SortieProduitItem> findBySortieProduitId(Long id);
    int deleteBySortieProduitId(Long id);



}
