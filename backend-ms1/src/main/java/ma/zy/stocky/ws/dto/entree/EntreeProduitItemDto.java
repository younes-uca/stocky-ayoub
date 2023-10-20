package  ma.zy.stocky.ws.dto.entree;

import ma.zy.stocky.zynerator.audit.Log;
import ma.zy.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zy.stocky.ws.dto.commun.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntreeProduitItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;
    private BigDecimal prix  ;

    private ProduitDto produit ;
    private EntreeProduitDto entreeProduit ;



    public EntreeProduitItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public EntreeProduitDto getEntreeProduit(){
        return this.entreeProduit;
    }

    public void setEntreeProduit(EntreeProduitDto entreeProduit){
        this.entreeProduit = entreeProduit;
    }






}
