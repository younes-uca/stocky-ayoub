package  ma.zy.stocky.ws.dto.entree;

import ma.zy.stocky.zynerator.audit.Log;
import ma.zy.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zy.stocky.ws.dto.commun.CollaborateurDto;
import ma.zy.stocky.ws.dto.commun.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireDto  extends AuditBaseDto {

    private String reference  ;
    private String dateInventaire ;
    private String description  ;

    private CollaborateurDto collaborateur ;

    private List<InventaireItemDto> inventaireItems ;


    public InventaireDto(){
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
    public String getDateInventaire(){
        return this.dateInventaire;
    }
    public void setDateInventaire(String dateInventaire){
        this.dateInventaire = dateInventaire;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public CollaborateurDto getCollaborateur(){
        return this.collaborateur;
    }

    public void setCollaborateur(CollaborateurDto collaborateur){
        this.collaborateur = collaborateur;
    }



    public List<InventaireItemDto> getInventaireItems(){
        return this.inventaireItems;
    }

    public void setInventaireItems(List<InventaireItemDto> inventaireItems){
        this.inventaireItems = inventaireItems;
    }



}
