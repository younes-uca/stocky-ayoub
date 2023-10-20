package ma.zy.stocky.service.impl.admin.entree;


import ma.zy.stocky.bean.core.entree.InventaireItem;
import ma.zy.stocky.dao.criteria.core.entree.InventaireItemCriteria;
import ma.zy.stocky.dao.facade.core.entree.InventaireItemDao;
import ma.zy.stocky.dao.specification.core.entree.InventaireItemSpecification;
import ma.zy.stocky.service.facade.admin.entree.InventaireItemAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zy.stocky.service.facade.admin.commun.ProduitAdminService ;
import ma.zy.stocky.bean.core.commun.Produit ;
import ma.zy.stocky.service.facade.admin.entree.InventaireAdminService ;
import ma.zy.stocky.bean.core.entree.Inventaire ;

import java.util.List;
@Service
public class InventaireItemAdminServiceImpl extends AbstractServiceImpl<InventaireItem, InventaireItemCriteria, InventaireItemDao> implements InventaireItemAdminService {






    public List<InventaireItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<InventaireItem> findByInventaireId(Long id){
        return dao.findByInventaireId(id);
    }
    public int deleteByInventaireId(Long id){
        return dao.deleteByInventaireId(id);
    }






    public void configure() {
        super.configure(InventaireItem.class, InventaireItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private InventaireAdminService inventaireService ;

    public InventaireItemAdminServiceImpl(InventaireItemDao dao) {
        super(dao);
    }

}
