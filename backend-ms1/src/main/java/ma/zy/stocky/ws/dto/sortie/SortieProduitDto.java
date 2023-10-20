package  ma.zy.stocky.ws.dto.sortie;

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


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SortieProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String dateSortieProduit ;
    private BigDecimal total  ;
    private String description  ;

    private CollaborateurDto collaborateur ;

    private List<SortieProduitItemDto> sortieProduitItems ;


    public SortieProduitDto(){
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
    public String getDateSortieProduit(){
        return this.dateSortieProduit;
    }
    public void setDateSortieProduit(String dateSortieProduit){
        this.dateSortieProduit = dateSortieProduit;
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


    public CollaborateurDto getCollaborateur(){
        return this.collaborateur;
    }

    public void setCollaborateur(CollaborateurDto collaborateur){
        this.collaborateur = collaborateur;
    }



    public List<SortieProduitItemDto> getSortieProduitItems(){
        return this.sortieProduitItems;
    }

    public void setSortieProduitItems(List<SortieProduitItemDto> sortieProduitItems){
        this.sortieProduitItems = sortieProduitItems;
    }



}
