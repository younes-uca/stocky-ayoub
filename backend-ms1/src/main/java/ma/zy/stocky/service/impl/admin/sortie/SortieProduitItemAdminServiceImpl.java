package ma.zy.stocky.service.impl.admin.sortie;


import ma.zy.stocky.bean.core.sortie.SortieProduitItem;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitItemCriteria;
import ma.zy.stocky.dao.facade.core.sortie.SortieProduitItemDao;
import ma.zy.stocky.dao.specification.core.sortie.SortieProduitItemSpecification;
import ma.zy.stocky.service.facade.admin.sortie.SortieProduitItemAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zy.stocky.service.facade.admin.commun.ProduitAdminService ;
import ma.zy.stocky.bean.core.commun.Produit ;
import ma.zy.stocky.service.facade.admin.sortie.SortieProduitAdminService ;
import ma.zy.stocky.bean.core.sortie.SortieProduit ;

import java.util.List;
@Service
public class SortieProduitItemAdminServiceImpl extends AbstractServiceImpl<SortieProduitItem, SortieProduitItemCriteria, SortieProduitItemDao> implements SortieProduitItemAdminService {






    public List<SortieProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<SortieProduitItem> findBySortieProduitId(Long id){
        return dao.findBySortieProduitId(id);
    }
    public int deleteBySortieProduitId(Long id){
        return dao.deleteBySortieProduitId(id);
    }






    public void configure() {
        super.configure(SortieProduitItem.class, SortieProduitItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private SortieProduitAdminService sortieProduitService ;

    public SortieProduitItemAdminServiceImpl(SortieProduitItemDao dao) {
        super(dao);
    }

}
