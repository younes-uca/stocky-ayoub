package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.dao.criteria.core.commun.ProduitCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface ProduitAdminService extends  IService<Produit,ProduitCriteria>  {

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);



}
