package  ma.zy.stocky.dao.specification.core.commun;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zy.stocky.bean.core.commun.Collaborateur;


public class CollaborateurSpecification extends  AbstractSpecification<CollaborateurCriteria, Collaborateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
    }

    public CollaborateurSpecification(CollaborateurCriteria criteria) {
        super(criteria);
    }

    public CollaborateurSpecification(CollaborateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
