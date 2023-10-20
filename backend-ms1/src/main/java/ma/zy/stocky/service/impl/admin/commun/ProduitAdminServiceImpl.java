package ma.zy.stocky.service.impl.admin.commun;


import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.dao.criteria.core.commun.ProduitCriteria;
import ma.zy.stocky.dao.facade.core.commun.ProduitDao;
import ma.zy.stocky.dao.specification.core.commun.ProduitSpecification;
import ma.zy.stocky.service.facade.admin.commun.ProduitAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zy.stocky.service.facade.admin.commun.CategorieProduitAdminService ;
import ma.zy.stocky.bean.core.commun.CategorieProduit ;
import ma.zy.stocky.service.facade.admin.commun.MarqueAdminService ;
import ma.zy.stocky.bean.core.commun.Marque ;
import ma.zy.stocky.service.facade.admin.commun.StockAdminService ;
import ma.zy.stocky.bean.core.commun.Stock ;

import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit, ProduitCriteria, ProduitDao> implements ProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Produit create(Produit t) {
        super.create(t);
        if (t.getStocks() != null) {
                t.getStocks().forEach(element-> {
                    element.setProduit(t);
                    stockService.create(element);
            });
        }
        return t;
    }

    public Produit findWithAssociatedLists(Long id){
        Produit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setStocks(stockService.findByProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        stockService.deleteByProduitId(id);
    }


    public void updateWithAssociatedLists(Produit produit){
    if(produit !=null && produit.getId() != null){
            List<List<Stock>> resultStocks= stockService.getToBeSavedAndToBeDeleted(stockService.findByProduitId(produit.getId()),produit.getStocks());
            stockService.delete(resultStocks.get(1));
            ListUtil.emptyIfNull(resultStocks.get(0)).forEach(e -> e.setProduit(produit));
            stockService.update(resultStocks.get(0),true);
    }
    }




    public List<Produit> findByCategorieProduitId(Long id){
        return dao.findByCategorieProduitId(id);
    }
    public int deleteByCategorieProduitId(Long id){
        return dao.deleteByCategorieProduitId(id);
    }
    public List<Produit> findByMarqueId(Long id){
        return dao.findByMarqueId(id);
    }
    public int deleteByMarqueId(Long id){
        return dao.deleteByMarqueId(id);
    }






    public void configure() {
        super.configure(Produit.class, ProduitSpecification.class);
    }


    @Autowired
    private CategorieProduitAdminService categorieProduitService ;
    @Autowired
    private MarqueAdminService marqueService ;
    @Autowired
    private StockAdminService stockService ;

    public ProduitAdminServiceImpl(ProduitDao dao) {
        super(dao);
    }

}
