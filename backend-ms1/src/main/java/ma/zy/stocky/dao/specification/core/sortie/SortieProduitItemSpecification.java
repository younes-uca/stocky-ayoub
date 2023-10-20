package  ma.zy.stocky.dao.specification.core.sortie;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitItemCriteria;
import ma.zy.stocky.bean.core.sortie.SortieProduitItem;


public class SortieProduitItemSpecification extends  AbstractSpecification<SortieProduitItemCriteria, SortieProduitItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("sortieProduit","id", criteria.getSortieProduit()==null?null:criteria.getSortieProduit().getId());
        addPredicateFk("sortieProduit","id", criteria.getSortieProduits());
        addPredicateFk("sortieProduit","reference", criteria.getSortieProduit()==null?null:criteria.getSortieProduit().getReference());
    }

    public SortieProduitItemSpecification(SortieProduitItemCriteria criteria) {
        super(criteria);
    }

    public SortieProduitItemSpecification(SortieProduitItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
