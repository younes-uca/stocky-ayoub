package ma.zy.stocky.service.impl.admin.entree;


import ma.zy.stocky.bean.core.entree.EntreeProduitItem;
import ma.zy.stocky.dao.criteria.core.entree.EntreeProduitItemCriteria;
import ma.zy.stocky.dao.facade.core.entree.EntreeProduitItemDao;
import ma.zy.stocky.dao.specification.core.entree.EntreeProduitItemSpecification;
import ma.zy.stocky.service.facade.admin.entree.EntreeProduitItemAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zy.stocky.service.facade.admin.commun.ProduitAdminService ;
import ma.zy.stocky.bean.core.commun.Produit ;
import ma.zy.stocky.service.facade.admin.entree.EntreeProduitAdminService ;
import ma.zy.stocky.bean.core.entree.EntreeProduit ;

import java.util.List;
@Service
public class EntreeProduitItemAdminServiceImpl extends AbstractServiceImpl<EntreeProduitItem, EntreeProduitItemCriteria, EntreeProduitItemDao> implements EntreeProduitItemAdminService {






    public List<EntreeProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<EntreeProduitItem> findByEntreeProduitId(Long id){
        return dao.findByEntreeProduitId(id);
    }
    public int deleteByEntreeProduitId(Long id){
        return dao.deleteByEntreeProduitId(id);
    }






    public void configure() {
        super.configure(EntreeProduitItem.class, EntreeProduitItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private EntreeProduitAdminService entreeProduitService ;

    public EntreeProduitItemAdminServiceImpl(EntreeProduitItemDao dao) {
        super(dao);
    }

}
