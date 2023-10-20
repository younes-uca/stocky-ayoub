package  ma.zy.stocky.ws.dto.commun;

import ma.zy.stocky.zynerator.audit.Log;
import ma.zy.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;
    private BigDecimal prixAchatMoyen  ;
    private BigDecimal prixVente  ;

    private CategorieProduitDto categorieProduit ;
    private MarqueDto marque ;

    private List<StockDto> stocks ;


    public ProduitDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }

    @Log
    public BigDecimal getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(BigDecimal prixVente){
        this.prixVente = prixVente;
    }


    public CategorieProduitDto getCategorieProduit(){
        return this.categorieProduit;
    }

    public void setCategorieProduit(CategorieProduitDto categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public MarqueDto getMarque(){
        return this.marque;
    }

    public void setMarque(MarqueDto marque){
        this.marque = marque;
    }



    public List<StockDto> getStocks(){
        return this.stocks;
    }

    public void setStocks(List<StockDto> stocks){
        this.stocks = stocks;
    }



}
