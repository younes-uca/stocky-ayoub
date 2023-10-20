package  ma.zy.stocky.dao.specification.core.sortie;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitCriteria;
import ma.zy.stocky.bean.core.sortie.SortieProduit;


public class SortieProduitSpecification extends  AbstractSpecification<SortieProduitCriteria, SortieProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateSortieProduit", criteria.getDateSortieProduit(), criteria.getDateSortieProduitFrom(), criteria.getDateSortieProduitTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("collaborateur","id", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getId());
        addPredicateFk("collaborateur","id", criteria.getCollaborateurs());
        addPredicateFk("collaborateur","prenom", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getPrenom());
    }

    public SortieProduitSpecification(SortieProduitCriteria criteria) {
        super(criteria);
    }

    public SortieProduitSpecification(SortieProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
