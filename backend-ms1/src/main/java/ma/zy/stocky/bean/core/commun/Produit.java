package ma.zy.stocky.bean.core.commun;

import java.util.Objects;
import java.util.List;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zy.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="produit_seq",sequenceName="produit_seq",allocationSize=1, initialValue = 1)
public class Produit   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;
    private BigDecimal prixAchatMoyen = BigDecimal.ZERO;
    private BigDecimal prixVente = BigDecimal.ZERO;

    private CategorieProduit categorieProduit ;
    private Marque marque ;

    private List<Stock> stocks ;

    public Produit(){
        super();
    }

    public Produit(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CategorieProduit getCategorieProduit(){
        return this.categorieProduit;
    }
    public void setCategorieProduit(CategorieProduit categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Marque getMarque(){
        return this.marque;
    }
    public void setMarque(Marque marque){
        this.marque = marque;
    }
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }
    public BigDecimal getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(BigDecimal prixVente){
        this.prixVente = prixVente;
    }
    @OneToMany(mappedBy = "produit")

    public List<Stock> getStocks(){
        return this.stocks;
    }
    public void setStocks(List<Stock> stocks){
        this.stocks = stocks;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id != null && id.equals(produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

