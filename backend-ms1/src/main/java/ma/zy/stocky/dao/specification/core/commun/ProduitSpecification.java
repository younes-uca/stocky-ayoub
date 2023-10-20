package  ma.zy.stocky.dao.specification.core.commun;

import ma.zy.stocky.zynerator.specification.AbstractSpecification;
import ma.zy.stocky.dao.criteria.core.commun.ProduitCriteria;
import ma.zy.stocky.bean.core.commun.Produit;


public class ProduitSpecification extends  AbstractSpecification<ProduitCriteria, Produit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("prixAchatMoyen", criteria.getPrixAchatMoyen(), criteria.getPrixAchatMoyenMin(), criteria.getPrixAchatMoyenMax());
        addPredicateBigDecimal("prixVente", criteria.getPrixVente(), criteria.getPrixVenteMin(), criteria.getPrixVenteMax());
        addPredicateFk("categorieProduit","id", criteria.getCategorieProduit()==null?null:criteria.getCategorieProduit().getId());
        addPredicateFk("categorieProduit","id", criteria.getCategorieProduits());
        addPredicateFk("categorieProduit","libelle", criteria.getCategorieProduit()==null?null:criteria.getCategorieProduit().getLibelle());
        addPredicateFk("marque","id", criteria.getMarque()==null?null:criteria.getMarque().getId());
        addPredicateFk("marque","id", criteria.getMarques());
        addPredicateFk("marque","libelle", criteria.getMarque()==null?null:criteria.getMarque().getLibelle());
    }

    public ProduitSpecification(ProduitCriteria criteria) {
        super(criteria);
    }

    public ProduitSpecification(ProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
