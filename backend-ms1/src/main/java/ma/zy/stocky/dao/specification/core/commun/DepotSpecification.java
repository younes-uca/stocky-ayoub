package  ma.zy.stocky.dao.specification.core.commun;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zy.stocky.bean.core.commun.Depot;


public class DepotSpecification extends  AbstractSpecification<DepotCriteria, Depot>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
    }

    public DepotSpecification(DepotCriteria criteria) {
        super(criteria);
    }

    public DepotSpecification(DepotCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
