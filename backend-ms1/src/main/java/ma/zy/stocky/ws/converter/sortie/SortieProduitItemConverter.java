package  ma.zy.stocky.ws.converter.sortie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zy.stocky.ws.converter.commun.ProduitConverter;
import ma.zy.stocky.ws.converter.sortie.SortieProduitConverter;

import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.bean.core.sortie.SortieProduit;


import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.sortie.SortieProduitItem;
import ma.zy.stocky.ws.dto.sortie.SortieProduitItemDto;

@Component
public class SortieProduitItemConverter extends AbstractConverter<SortieProduitItem, SortieProduitItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private SortieProduitConverter sortieProduitConverter ;
    private boolean produit;
    private boolean sortieProduit;

    public  SortieProduitItemConverter(){
        super(SortieProduitItem.class, SortieProduitItemDto.class);
    }

    @Override
    public SortieProduitItem toItem(SortieProduitItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        SortieProduitItem item = new SortieProduitItem();
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

            if(dto.getSortieProduit() != null && dto.getSortieProduit().getId() != null){
                item.setSortieProduit(new SortieProduit());
                item.getSortieProduit().setId(dto.getSortieProduit().getId());
                item.getSortieProduit().setReference(dto.getSortieProduit().getReference());
            }




        return item;
        }
    }

    @Override
    public SortieProduitItemDto toDto(SortieProduitItem item) {
        if (item == null) {
            return null;
        } else {
            SortieProduitItemDto dto = new SortieProduitItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.sortieProduit && item.getSortieProduit()!=null) {
            dto.setSortieProduit(sortieProduitConverter.toDto(item.getSortieProduit())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.sortieProduit = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public SortieProduitConverter getSortieProduitConverter(){
        return this.sortieProduitConverter;
    }
    public void setSortieProduitConverter(SortieProduitConverter sortieProduitConverter ){
        this.sortieProduitConverter = sortieProduitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isSortieProduit(){
        return this.sortieProduit;
    }
    public void  setSortieProduit(boolean sortieProduit){
        this.sortieProduit = sortieProduit;
    }
}
