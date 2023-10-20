package  ma.zy.stocky.dao.criteria.core.entree;


import ma.zy.stocky.dao.criteria.core.commun.CollaborateurCriteria;

import ma.zy.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class InventaireCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateInventaire;
    private LocalDateTime dateInventaireFrom;
    private LocalDateTime dateInventaireTo;
    private String description;
    private String descriptionLike;

    private CollaborateurCriteria collaborateur ;
    private List<CollaborateurCriteria> collaborateurs ;


    public InventaireCriteria(){}

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

    public LocalDateTime getDateInventaire(){
        return this.dateInventaire;
    }
    public void setDateInventaire(LocalDateTime dateInventaire){
        this.dateInventaire = dateInventaire;
    }
    public LocalDateTime getDateInventaireFrom(){
        return this.dateInventaireFrom;
    }
    public void setDateInventaireFrom(LocalDateTime dateInventaireFrom){
        this.dateInventaireFrom = dateInventaireFrom;
    }
    public LocalDateTime getDateInventaireTo(){
        return this.dateInventaireTo;
    }
    public void setDateInventaireTo(LocalDateTime dateInventaireTo){
        this.dateInventaireTo = dateInventaireTo;
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
