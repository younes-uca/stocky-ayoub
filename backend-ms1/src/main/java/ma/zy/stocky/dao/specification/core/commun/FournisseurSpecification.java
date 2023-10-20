package  ma.zy.stocky.dao.specification.core.commun;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zy.stocky.bean.core.commun.Fournisseur;


public class FournisseurSpecification extends  AbstractSpecification<FournisseurCriteria, Fournisseur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("telephone", criteria.getTelephone(),criteria.getTelephoneLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
    }

    public FournisseurSpecification(FournisseurCriteria criteria) {
        super(criteria);
    }

    public FournisseurSpecification(FournisseurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
