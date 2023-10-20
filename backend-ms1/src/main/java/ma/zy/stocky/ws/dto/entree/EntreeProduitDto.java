package  ma.zy.stocky.ws.dto.entree;

import ma.zy.stocky.zynerator.audit.Log;
import ma.zy.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zy.stocky.ws.dto.commun.CollaborateurDto;
import ma.zy.stocky.ws.dto.commun.ProduitDto;
import ma.zy.stocky.ws.dto.commun.FournisseurDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntreeProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String dateEntreeProduit ;
    private BigDecimal total  ;
    private String description  ;

    private FournisseurDto fournisseur ;
    private CollaborateurDto collaborateur ;

    private List<EntreeProduitItemDto> entreeProduitItems ;


    public EntreeProduitDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEntreeProduit(){
        return this.dateEntreeProduit;
    }
    public void setDateEntreeProduit(String dateEntreeProduit){
        this.dateEntreeProduit = dateEntreeProduit;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public FournisseurDto getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur){
        this.fournisseur = fournisseur;
    }
    public CollaborateurDto getCollaborateur(){
        return this.collaborateur;
    }

    public void setCollaborateur(CollaborateurDto collaborateur){
        this.collaborateur = collaborateur;
    }



    public List<EntreeProduitItemDto> getEntreeProduitItems(){
        return this.entreeProduitItems;
    }

    public void setEntreeProduitItems(List<EntreeProduitItemDto> entreeProduitItems){
        this.entreeProduitItems = entreeProduitItems;
    }



}
