package  ma.zy.stocky.ws.converter.entree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zy.stocky.ws.converter.commun.ProduitConverter;
import ma.zy.stocky.ws.converter.entree.EntreeProduitConverter;

import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.bean.core.entree.EntreeProduit;


import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.entree.EntreeProduitItem;
import ma.zy.stocky.ws.dto.entree.EntreeProduitItemDto;

@Component
public class EntreeProduitItemConverter extends AbstractConverter<EntreeProduitItem, EntreeProduitItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private EntreeProduitConverter entreeProduitConverter ;
    private boolean produit;
    private boolean entreeProduit;

    public  EntreeProduitItemConverter(){
        super(EntreeProduitItem.class, EntreeProduitItemDto.class);
    }

    @Override
    public EntreeProduitItem toItem(EntreeProduitItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntreeProduitItem item = new EntreeProduitItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(dto.getEntreeProduit() != null && dto.getEntreeProduit().getId() != null){
                item.setEntreeProduit(new EntreeProduit());
                item.getEntreeProduit().setId(dto.getEntreeProduit().getId());
                item.getEntreeProduit().setReference(dto.getEntreeProduit().getReference());
            }




        return item;
        }
    }

    @Override
    public EntreeProduitItemDto toDto(EntreeProduitItem item) {
        if (item == null) {
            return null;
        } else {
            EntreeProduitItemDto dto = new EntreeProduitItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.entreeProduit && item.getEntreeProduit()!=null) {
            dto.setEntreeProduit(entreeProduitConverter.toDto(item.getEntreeProduit())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.entreeProduit = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public EntreeProduitConverter getEntreeProduitConverter(){
        return this.entreeProduitConverter;
    }
    public void setEntreeProduitConverter(EntreeProduitConverter entreeProduitConverter ){
        this.entreeProduitConverter = entreeProduitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isEntreeProduit(){
        return this.entreeProduit;
    }
    public void  setEntreeProduit(boolean entreeProduit){
        this.entreeProduit = entreeProduit;
    }
}
