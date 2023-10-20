package ma.zy.stocky.bean.core.entree;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zy.stocky.bean.core.commun.Collaborateur;
import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.bean.core.commun.Fournisseur;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zy.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "entree_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="entree_produit_seq",sequenceName="entree_produit_seq",allocationSize=1, initialValue = 1)
public class EntreeProduit   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateEntreeProduit ;
    private BigDecimal total = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Fournisseur fournisseur ;
    private Collaborateur collaborateur ;

    private List<EntreeProduitItem> entreeProduitItems ;

    public EntreeProduit(){
        super();
    }

    public EntreeProduit(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="entree_produit_seq")
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
    public LocalDateTime getDateEntreeProduit(){
        return this.dateEntreeProduit;
    }
    public void setDateEntreeProduit(LocalDateTime dateEntreeProduit){
        this.dateEntreeProduit = dateEntreeProduit;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Collaborateur getCollaborateur(){
        return this.collaborateur;
    }
    public void setCollaborateur(Collaborateur collaborateur){
        this.collaborateur = collaborateur;
    }
    @OneToMany(mappedBy = "entreeProduit")

    public List<EntreeProduitItem> getEntreeProduitItems(){
        return this.entreeProduitItems;
    }
    public void setEntreeProduitItems(List<EntreeProduitItem> entreeProduitItems){
        this.entreeProduitItems = entreeProduitItems;
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
        EntreeProduit entreeProduit = (EntreeProduit) o;
        return id != null && id.equals(entreeProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

