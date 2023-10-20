package  ma.zy.stocky.ws.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zy.stocky.ws.converter.commun.ProduitConverter;
import ma.zy.stocky.ws.converter.entree.InventaireConverter;

import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.bean.core.entree.Inventaire;


import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.entree.InventaireItem;
import ma.zy.stocky.ws.dto.entree.InventaireItemDto;

@Component
public class InventaireItemConverter extends AbstractConverter<InventaireItem, InventaireItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private InventaireConverter inventaireConverter ;
    private boolean produit;
    private boolean inventaire;

    public  InventaireItemConverter(){
        super(InventaireItem.class, InventaireItemDto.class);
    }

    @Override
    public InventaireItem toItem(InventaireItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        InventaireItem item = new InventaireItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantiteEstime()))
                item.setQuantiteEstime(dto.getQuantiteEstime());
            if(StringUtil.isNotEmpty(dto.getQuantiteReelle()))
                item.setQuantiteReelle(dto.getQuantiteReelle());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(dto.getInventaire() != null && dto.getInventaire().getId() != null){
                item.setInventaire(new Inventaire());
                item.getInventaire().setId(dto.getInventaire().getId());
                item.getInventaire().setReference(dto.getInventaire().getReference());
            }




        return item;
        }
    }

    @Override
    public InventaireItemDto toDto(InventaireItem item) {
        if (item == null) {
            return null;
        } else {
            InventaireItemDto dto = new InventaireItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantiteEstime()))
                dto.setQuantiteEstime(item.getQuantiteEstime());
            if(StringUtil.isNotEmpty(item.getQuantiteReelle()))
                dto.setQuantiteReelle(item.getQuantiteReelle());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.inventaire && item.getInventaire()!=null) {
            dto.setInventaire(inventaireConverter.toDto(item.getInventaire())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.inventaire = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public InventaireConverter getInventaireConverter(){
        return this.inventaireConverter;
    }
    public void setInventaireConverter(InventaireConverter inventaireConverter ){
        this.inventaireConverter = inventaireConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isInventaire(){
        return this.inventaire;
    }
    public void  setInventaire(boolean inventaire){
        this.inventaire = inventaire;
    }
}
