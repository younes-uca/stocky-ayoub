package  ma.zy.stocky.dao.specification.core.entree;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.entree.InventaireCriteria;
import ma.zy.stocky.bean.core.entree.Inventaire;


public class InventaireSpecification extends  AbstractSpecification<InventaireCriteria, Inventaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateInventaire", criteria.getDateInventaire(), criteria.getDateInventaireFrom(), criteria.getDateInventaireTo());
        addPredicateFk("collaborateur","id", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getId());
        addPredicateFk("collaborateur","id", criteria.getCollaborateurs());
        addPredicateFk("collaborateur","prenom", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getPrenom());
    }

    public InventaireSpecification(InventaireCriteria criteria) {
        super(criteria);
    }

    public InventaireSpecification(InventaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
