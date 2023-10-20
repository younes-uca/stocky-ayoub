package  ma.zy.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zy.stocky.zynerator.util.ListUtil;

import ma.zy.stocky.ws.converter.commun.CategorieProduitConverter;
import ma.zy.stocky.ws.converter.commun.MarqueConverter;
import ma.zy.stocky.ws.converter.commun.DepotConverter;
import ma.zy.stocky.ws.converter.commun.StockConverter;



import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.commun.Produit;
import ma.zy.stocky.ws.dto.commun.ProduitDto;

@Component
public class ProduitConverter extends AbstractConverter<Produit, ProduitDto> {

    @Autowired
    private CategorieProduitConverter categorieProduitConverter ;
    @Autowired
    private MarqueConverter marqueConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private StockConverter stockConverter ;
    private boolean categorieProduit;
    private boolean marque;
    private boolean stocks;

    public  ProduitConverter(){
        super(Produit.class, ProduitDto.class);
        init(true);
    }

    @Override
    public Produit toItem(ProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        Produit item = new Produit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPrixAchatMoyen()))
                item.setPrixAchatMoyen(dto.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(dto.getPrixVente()))
                item.setPrixVente(dto.getPrixVente());
            if(this.categorieProduit && dto.getCategorieProduit()!=null &&  dto.getCategorieProduit().getId() != null)
                item.setCategorieProduit(categorieProduitConverter.toItem(dto.getCategorieProduit())) ;

            if(this.marque && dto.getMarque()!=null &&  dto.getMarque().getId() != null)
                item.setMarque(marqueConverter.toItem(dto.getMarque())) ;


            if(this.stocks && ListUtil.isNotEmpty(dto.getStocks()))
                item.setStocks(stockConverter.toItem(dto.getStocks()));


        return item;
        }
    }

    @Override
    public ProduitDto toDto(Produit item) {
        if (item == null) {
            return null;
        } else {
            ProduitDto dto = new ProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getPrixAchatMoyen()))
                dto.setPrixAchatMoyen(item.getPrixAchatMoyen());
            if(StringUtil.isNotEmpty(item.getPrixVente()))
                dto.setPrixVente(item.getPrixVente());
        if(this.categorieProduit && item.getCategorieProduit()!=null) {
            dto.setCategorieProduit(categorieProduitConverter.toDto(item.getCategorieProduit())) ;
        }
        if(this.marque && item.getMarque()!=null) {
            dto.setMarque(marqueConverter.toDto(item.getMarque())) ;
        }
        if(this.stocks && ListUtil.isNotEmpty(item.getStocks())){
            stockConverter.init(true);
            stockConverter.setProduit(false);
            dto.setStocks(stockConverter.toDto(item.getStocks()));
            stockConverter.setProduit(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.stocks = value;
    }

    public void initObject(boolean value) {
        this.categorieProduit = value;
        this.marque = value;
    }


    public CategorieProduitConverter getCategorieProduitConverter(){
        return this.categorieProduitConverter;
    }
    public void setCategorieProduitConverter(CategorieProduitConverter categorieProduitConverter ){
        this.categorieProduitConverter = categorieProduitConverter;
    }
    public MarqueConverter getMarqueConverter(){
        return this.marqueConverter;
    }
    public void setMarqueConverter(MarqueConverter marqueConverter ){
        this.marqueConverter = marqueConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public StockConverter getStockConverter(){
        return this.stockConverter;
    }
    public void setStockConverter(StockConverter stockConverter ){
        this.stockConverter = stockConverter;
    }
    public boolean  isCategorieProduit(){
        return this.categorieProduit;
    }
    public void  setCategorieProduit(boolean categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public boolean  isMarque(){
        return this.marque;
    }
    public void  setMarque(boolean marque){
        this.marque = marque;
    }
    public boolean  isStocks(){
        return this.stocks ;
    }
    public void  setStocks(boolean stocks ){
        this.stocks  = stocks ;
    }
}
