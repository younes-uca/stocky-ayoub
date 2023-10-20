package  ma.zy.stocky.dao.criteria.core.entree;


import ma.zy.stocky.dao.criteria.core.commun.ProduitCriteria;

import ma.zy.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EntreeProduitItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String prix;
    private String prixMin;
    private String prixMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private EntreeProduitCriteria entreeProduit ;
    private List<EntreeProduitCriteria> entreeProduits ;


    public EntreeProduitItemCriteria(){}

    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }   
    public String getQuantiteMin(){
        return this.quantiteMin;
    }
    public void setQuantiteMin(String quantiteMin){
        this.quantiteMin = quantiteMin;
    }
    public String getQuantiteMax(){
        return this.quantiteMax;
    }
    public void setQuantiteMax(String quantiteMax){
        this.quantiteMax = quantiteMax;
    }
      
    public String getPrix(){
        return this.prix;
    }
    public void setPrix(String prix){
        this.prix = prix;
    }   
    public String getPrixMin(){
        return this.prixMin;
    }
    public void setPrixMin(String prixMin){
        this.prixMin = prixMin;
    }
    public String getPrixMax(){
        return this.prixMax;
    }
    public void setPrixMax(String prixMax){
        this.prixMax = prixMax;
    }
      

    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public EntreeProduitCriteria getEntreeProduit(){
        return this.entreeProduit;
    }

    public void setEntreeProduit(EntreeProduitCriteria entreeProduit){
        this.entreeProduit = entreeProduit;
    }
    public List<EntreeProduitCriteria> getEntreeProduits(){
        return this.entreeProduits;
    }

    public void setEntreeProduits(List<EntreeProduitCriteria> entreeProduits){
        this.entreeProduits = entreeProduits;
    }
}
