package  ma.zy.stocky.dao.specification.core.entree;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zy.stocky.bean.core.entree.EntreeProduit;


public class EntreeProduitSpecification extends  AbstractSpecification<EntreeProduitCriteria, EntreeProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateEntreeProduit", criteria.getDateEntreeProduit(), criteria.getDateEntreeProduitFrom(), criteria.getDateEntreeProduitTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","prenom", criteria.getFournisseur()==null?null:criteria.getFournisseur().getPrenom());
        addPredicateFk("collaborateur","id", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getId());
        addPredicateFk("collaborateur","id", criteria.getCollaborateurs());
        addPredicateFk("collaborateur","prenom", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getPrenom());
    }

    public EntreeProduitSpecification(EntreeProduitCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitSpecification(EntreeProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
