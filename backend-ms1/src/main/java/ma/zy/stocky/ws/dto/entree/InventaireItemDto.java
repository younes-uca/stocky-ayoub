package  ma.zy.stocky.ws.dto.entree;

import ma.zy.stocky.zynerator.audit.Log;
import ma.zy.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zy.stocky.ws.dto.commun.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireItemDto  extends AuditBaseDto {

    private BigDecimal quantiteEstime  ;
    private BigDecimal quantiteReelle  ;

    private ProduitDto produit ;
    private InventaireDto inventaire ;



    public InventaireItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(BigDecimal quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }

    @Log
    public BigDecimal getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(BigDecimal quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public InventaireDto getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(InventaireDto inventaire){
        this.inventaire = inventaire;
    }






}
