package  ma.zy.stocky.ws.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zy.stocky.zynerator.util.ListUtil;

import ma.zy.stocky.ws.converter.commun.CollaborateurConverter;
import ma.zy.stocky.ws.converter.commun.ProduitConverter;
import ma.zy.stocky.ws.converter.commun.FournisseurConverter;
import ma.zy.stocky.ws.converter.entree.EntreeProduitItemConverter;



import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.entree.EntreeProduit;
import ma.zy.stocky.ws.dto.entree.EntreeProduitDto;

@Component
public class EntreeProduitConverter extends AbstractConverter<EntreeProduit, EntreeProduitDto> {

    @Autowired
    private CollaborateurConverter collaborateurConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private EntreeProduitItemConverter entreeProduitItemConverter ;
    private boolean fournisseur;
    private boolean collaborateur;
    private boolean entreeProduitItems;

    public  EntreeProduitConverter(){
        super(EntreeProduit.class, EntreeProduitDto.class);
        init(true);
    }

    @Override
    public EntreeProduit toItem(EntreeProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntreeProduit item = new EntreeProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateEntreeProduit()))
                item.setDateEntreeProduit(DateUtil.stringEnToDate(dto.getDateEntreeProduit()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.collaborateur && dto.getCollaborateur()!=null &&  dto.getCollaborateur().getId() != null)
                item.setCollaborateur(collaborateurConverter.toItem(dto.getCollaborateur())) ;


            if(this.entreeProduitItems && ListUtil.isNotEmpty(dto.getEntreeProduitItems()))
                item.setEntreeProduitItems(entreeProduitItemConverter.toItem(dto.getEntreeProduitItems()));


        return item;
        }
    }

    @Override
    public EntreeProduitDto toDto(EntreeProduit item) {
        if (item == null) {
            return null;
        } else {
            EntreeProduitDto dto = new EntreeProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateEntreeProduit()!=null)
                dto.setDateEntreeProduit(DateUtil.dateTimeToString(item.getDateEntreeProduit()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.collaborateur && item.getCollaborateur()!=null) {
            dto.setCollaborateur(collaborateurConverter.toDto(item.getCollaborateur())) ;
        }
        if(this.entreeProduitItems && ListUtil.isNotEmpty(item.getEntreeProduitItems())){
            entreeProduitItemConverter.init(true);
            entreeProduitItemConverter.setEntreeProduit(false);
            dto.setEntreeProduitItems(entreeProduitItemConverter.toDto(item.getEntreeProduitItems()));
            entreeProduitItemConverter.setEntreeProduit(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.entreeProduitItems = value;
    }

    public void initObject(boolean value) {
        this.fournisseur = value;
        this.collaborateur = value;
    }


    public CollaborateurConverter getCollaborateurConverter(){
        return this.collaborateurConverter;
    }
    public void setCollaborateurConverter(CollaborateurConverter collaborateurConverter ){
        this.collaborateurConverter = collaborateurConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public EntreeProduitItemConverter getEntreeProduitItemConverter(){
        return this.entreeProduitItemConverter;
    }
    public void setEntreeProduitItemConverter(EntreeProduitItemConverter entreeProduitItemConverter ){
        this.entreeProduitItemConverter = entreeProduitItemConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isCollaborateur(){
        return this.collaborateur;
    }
    public void  setCollaborateur(boolean collaborateur){
        this.collaborateur = collaborateur;
    }
    public boolean  isEntreeProduitItems(){
        return this.entreeProduitItems ;
    }
    public void  setEntreeProduitItems(boolean entreeProduitItems ){
        this.entreeProduitItems  = entreeProduitItems ;
    }
}
