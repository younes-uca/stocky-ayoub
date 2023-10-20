package  ma.zy.stocky.dao.specification.core.entree;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.entree.InventaireItemCriteria;
import ma.zy.stocky.bean.core.entree.InventaireItem;


public class InventaireItemSpecification extends  AbstractSpecification<InventaireItemCriteria, InventaireItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantiteEstime", criteria.getQuantiteEstime(), criteria.getQuantiteEstimeMin(), criteria.getQuantiteEstimeMax());
        addPredicateBigDecimal("quantiteReelle", criteria.getQuantiteReelle(), criteria.getQuantiteReelleMin(), criteria.getQuantiteReelleMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("inventaire","id", criteria.getInventaire()==null?null:criteria.getInventaire().getId());
        addPredicateFk("inventaire","id", criteria.getInventaires());
        addPredicateFk("inventaire","reference", criteria.getInventaire()==null?null:criteria.getInventaire().getReference());
    }

    public InventaireItemSpecification(InventaireItemCriteria criteria) {
        super(criteria);
    }

    public InventaireItemSpecification(InventaireItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
