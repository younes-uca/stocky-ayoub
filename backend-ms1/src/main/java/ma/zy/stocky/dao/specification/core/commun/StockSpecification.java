package  ma.zy.stocky.dao.specification.core.commun;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.commun.StockCriteria;
import ma.zy.stocky.bean.core.commun.Stock;


public class StockSpecification extends  AbstractSpecification<StockCriteria, Stock>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("depot","id", criteria.getDepot()==null?null:criteria.getDepot().getId());
        addPredicateFk("depot","id", criteria.getDepots());
        addPredicateFk("depot","libelle", criteria.getDepot()==null?null:criteria.getDepot().getLibelle());
    }

    public StockSpecification(StockCriteria criteria) {
        super(criteria);
    }

    public StockSpecification(StockCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
