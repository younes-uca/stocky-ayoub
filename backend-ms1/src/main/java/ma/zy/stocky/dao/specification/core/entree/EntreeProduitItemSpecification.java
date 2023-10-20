package  ma.zy.stocky.dao.specification.core.entree;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.entree.EntreeProduitItemCriteria;
import ma.zy.stocky.bean.core.entree.EntreeProduitItem;


public class EntreeProduitItemSpecification extends  AbstractSpecification<EntreeProduitItemCriteria, EntreeProduitItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getId());
        addPredicateFk("entreeProduit","id", criteria.getEntreeProduits());
        addPredicateFk("entreeProduit","reference", criteria.getEntreeProduit()==null?null:criteria.getEntreeProduit().getReference());
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria) {
        super(criteria);
    }

    public EntreeProduitItemSpecification(EntreeProduitItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
