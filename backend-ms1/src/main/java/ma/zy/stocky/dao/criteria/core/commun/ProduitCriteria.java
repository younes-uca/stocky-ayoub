package  ma.zy.stocky.dao.criteria.core.commun;



import ma.zy.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProduitCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String libelle;
    private String libelleLike;
    private String prixAchatMoyen;
    private String prixAchatMoyenMin;
    private String prixAchatMoyenMax;
    private String prixVente;
    private String prixVenteMin;
    private String prixVenteMax;

    private CategorieProduitCriteria categorieProduit ;
    private List<CategorieProduitCriteria> categorieProduits ;
    private MarqueCriteria marque ;
    private List<MarqueCriteria> marques ;


    public ProduitCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(String prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }   
    public String getPrixAchatMoyenMin(){
        return this.prixAchatMoyenMin;
    }
    public void setPrixAchatMoyenMin(String prixAchatMoyenMin){
        this.prixAchatMoyenMin = prixAchatMoyenMin;
    }
    public String getPrixAchatMoyenMax(){
        return this.prixAchatMoyenMax;
    }
    public void setPrixAchatMoyenMax(String prixAchatMoyenMax){
        this.prixAchatMoyenMax = prixAchatMoyenMax;
    }
      
    public String getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(String prixVente){
        this.prixVente = prixVente;
    }   
    public String getPrixVenteMin(){
        return this.prixVenteMin;
    }
    public void setPrixVenteMin(String prixVenteMin){
        this.prixVenteMin = prixVenteMin;
    }
    public String getPrixVenteMax(){
        return this.prixVenteMax;
    }
    public void setPrixVenteMax(String prixVenteMax){
        this.prixVenteMax = prixVenteMax;
    }
      

    public CategorieProduitCriteria getCategorieProduit(){
        return this.categorieProduit;
    }

    public void setCategorieProduit(CategorieProduitCriteria categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public List<CategorieProduitCriteria> getCategorieProduits(){
        return this.categorieProduits;
    }

    public void setCategorieProduits(List<CategorieProduitCriteria> categorieProduits){
        this.categorieProduits = categorieProduits;
    }
    public MarqueCriteria getMarque(){
        return this.marque;
    }

    public void setMarque(MarqueCriteria marque){
        this.marque = marque;
    }
    public List<MarqueCriteria> getMarques(){
        return this.marques;
    }

    public void setMarques(List<MarqueCriteria> marques){
        this.marques = marques;
    }
}
