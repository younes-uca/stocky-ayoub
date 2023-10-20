package ma.zy.stocky.bean.core.entree;

import java.util.Objects;





import ma.zy.stocky.bean.core.commun.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zy.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "entree_produit_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="entree_produit_item_seq",sequenceName="entree_produit_item_seq",allocationSize=1, initialValue = 1)
public class EntreeProduitItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal prix = BigDecimal.ZERO;

    private Produit produit ;
    private EntreeProduit entreeProduit ;


    public EntreeProduitItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="entree_produit_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EntreeProduit getEntreeProduit(){
        return this.entreeProduit;
    }
    public void setEntreeProduit(EntreeProduit entreeProduit){
        this.entreeProduit = entreeProduit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntreeProduitItem entreeProduitItem = (EntreeProduitItem) o;
        return id != null && id.equals(entreeProduitItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

