package  ma.zy.stocky.ws.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zy.stocky.zynerator.util.ListUtil;

import ma.zy.stocky.ws.converter.commun.CollaborateurConverter;
import ma.zy.stocky.ws.converter.commun.ProduitConverter;
import ma.zy.stocky.ws.converter.entree.InventaireItemConverter;



import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.entree.Inventaire;
import ma.zy.stocky.ws.dto.entree.InventaireDto;

@Component
public class InventaireConverter extends AbstractConverter<Inventaire, InventaireDto> {

    @Autowired
    private CollaborateurConverter collaborateurConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private InventaireItemConverter inventaireItemConverter ;
    private boolean collaborateur;
    private boolean inventaireItems;

    public  InventaireConverter(){
        super(Inventaire.class, InventaireDto.class);
        init(true);
    }

    @Override
    public Inventaire toItem(InventaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Inventaire item = new Inventaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateInventaire()))
                item.setDateInventaire(DateUtil.stringEnToDate(dto.getDateInventaire()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.collaborateur && dto.getCollaborateur()!=null &&  dto.getCollaborateur().getId() != null)
                item.setCollaborateur(collaborateurConverter.toItem(dto.getCollaborateur())) ;


            if(this.inventaireItems && ListUtil.isNotEmpty(dto.getInventaireItems()))
                item.setInventaireItems(inventaireItemConverter.toItem(dto.getInventaireItems()));


        return item;
        }
    }

    @Override
    public InventaireDto toDto(Inventaire item) {
        if (item == null) {
            return null;
        } else {
            InventaireDto dto = new InventaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateInventaire()!=null)
                dto.setDateInventaire(DateUtil.dateTimeToString(item.getDateInventaire()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.collaborateur && item.getCollaborateur()!=null) {
            dto.setCollaborateur(collaborateurConverter.toDto(item.getCollaborateur())) ;
        }
        if(this.inventaireItems && ListUtil.isNotEmpty(item.getInventaireItems())){
            inventaireItemConverter.init(true);
            inventaireItemConverter.setInventaire(false);
            dto.setInventaireItems(inventaireItemConverter.toDto(item.getInventaireItems()));
            inventaireItemConverter.setInventaire(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.inventaireItems = value;
    }

    public void initObject(boolean value) {
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
    public InventaireItemConverter getInventaireItemConverter(){
        return this.inventaireItemConverter;
    }
    public void setInventaireItemConverter(InventaireItemConverter inventaireItemConverter ){
        this.inventaireItemConverter = inventaireItemConverter;
    }
    public boolean  isCollaborateur(){
        return this.collaborateur;
    }
    public void  setCollaborateur(boolean collaborateur){
        this.collaborateur = collaborateur;
    }
    public boolean  isInventaireItems(){
        return this.inventaireItems ;
    }
    public void  setInventaireItems(boolean inventaireItems ){
        this.inventaireItems  = inventaireItems ;
    }
}
