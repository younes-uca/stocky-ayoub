package  ma.zy.stocky.ws.converter.sortie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zy.stocky.zynerator.util.ListUtil;

import ma.zy.stocky.ws.converter.commun.CollaborateurConverter;
import ma.zy.stocky.ws.converter.commun.ProduitConverter;
import ma.zy.stocky.ws.converter.sortie.SortieProduitItemConverter;



import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.sortie.SortieProduit;
import ma.zy.stocky.ws.dto.sortie.SortieProduitDto;

@Component
public class SortieProduitConverter extends AbstractConverter<SortieProduit, SortieProduitDto> {

    @Autowired
    private CollaborateurConverter collaborateurConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private SortieProduitItemConverter sortieProduitItemConverter ;
    private boolean collaborateur;
    private boolean sortieProduitItems;

    public  SortieProduitConverter(){
        super(SortieProduit.class, SortieProduitDto.class);
        init(true);
    }

    @Override
    public SortieProduit toItem(SortieProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        SortieProduit item = new SortieProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateSortieProduit()))
                item.setDateSortieProduit(DateUtil.stringEnToDate(dto.getDateSortieProduit()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.collaborateur && dto.getCollaborateur()!=null &&  dto.getCollaborateur().getId() != null)
                item.setCollaborateur(collaborateurConverter.toItem(dto.getCollaborateur())) ;


            if(this.sortieProduitItems && ListUtil.isNotEmpty(dto.getSortieProduitItems()))
                item.setSortieProduitItems(sortieProduitItemConverter.toItem(dto.getSortieProduitItems()));


        return item;
        }
    }

    @Override
    public SortieProduitDto toDto(SortieProduit item) {
        if (item == null) {
            return null;
        } else {
            SortieProduitDto dto = new SortieProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateSortieProduit()!=null)
                dto.setDateSortieProduit(DateUtil.dateTimeToString(item.getDateSortieProduit()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.collaborateur && item.getCollaborateur()!=null) {
            dto.setCollaborateur(collaborateurConverter.toDto(item.getCollaborateur())) ;
        }
        if(this.sortieProduitItems && ListUtil.isNotEmpty(item.getSortieProduitItems())){
            sortieProduitItemConverter.init(true);
            sortieProduitItemConverter.setSortieProduit(false);
            dto.setSortieProduitItems(sortieProduitItemConverter.toDto(item.getSortieProduitItems()));
            sortieProduitItemConverter.setSortieProduit(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.sortieProduitItems = value;
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
    public SortieProduitItemConverter getSortieProduitItemConverter(){
        return this.sortieProduitItemConverter;
    }
    public void setSortieProduitItemConverter(SortieProduitItemConverter sortieProduitItemConverter ){
        this.sortieProduitItemConverter = sortieProduitItemConverter;
    }
    public boolean  isCollaborateur(){
        return this.collaborateur;
    }
    public void  setCollaborateur(boolean collaborateur){
        this.collaborateur = collaborateur;
    }
    public boolean  isSortieProduitItems(){
        return this.sortieProduitItems ;
    }
    public void  setSortieProduitItems(boolean sortieProduitItems ){
        this.sortieProduitItems  = sortieProduitItems ;
    }
}
