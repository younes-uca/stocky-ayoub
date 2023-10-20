package  ma.zy.stocky.dao.criteria.core.sortie;


import ma.zy.stocky.dao.criteria.core.commun.CollaborateurCriteria;

import ma.zy.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SortieProduitCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateSortieProduit;
    private LocalDateTime dateSortieProduitFrom;
    private LocalDateTime dateSortieProduitTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String description;
    private String descriptionLike;

    private CollaborateurCriteria collaborateur ;
    private List<CollaborateurCriteria> collaborateurs ;


    public SortieProduitCriteria(){}

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

    public LocalDateTime getDateSortieProduit(){
        return this.dateSortieProduit;
    }
    public void setDateSortieProduit(LocalDateTime dateSortieProduit){
        this.dateSortieProduit = dateSortieProduit;
    }
    public LocalDateTime getDateSortieProduitFrom(){
        return this.dateSortieProduitFrom;
    }
    public void setDateSortieProduitFrom(LocalDateTime dateSortieProduitFrom){
        this.dateSortieProduitFrom = dateSortieProduitFrom;
    }
    public LocalDateTime getDateSortieProduitTo(){
        return this.dateSortieProduitTo;
    }
    public void setDateSortieProduitTo(LocalDateTime dateSortieProduitTo){
        this.dateSortieProduitTo = dateSortieProduitTo;
    }
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public CollaborateurCriteria getCollaborateur(){
        return this.collaborateur;
    }

    public void setCollaborateur(CollaborateurCriteria collaborateur){
        this.collaborateur = collaborateur;
    }
    public List<CollaborateurCriteria> getCollaborateurs(){
        return this.collaborateurs;
    }

    public void setCollaborateurs(List<CollaborateurCriteria> collaborateurs){
        this.collaborateurs = collaborateurs;
    }
}
