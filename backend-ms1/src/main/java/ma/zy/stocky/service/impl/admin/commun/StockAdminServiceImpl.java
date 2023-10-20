package ma.zy.stocky.service.impl.admin.commun;


import ma.zy.stocky.bean.core.commun.Stock;
import ma.zy.stocky.dao.criteria.core.commun.StockCriteria;
import ma.zy.stocky.dao.facade.core.commun.StockDao;
import ma.zy.stocky.dao.specification.core.commun.StockSpecification;
import ma.zy.stocky.service.facade.admin.commun.StockAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.service.Attribute;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zy.stocky.zynerator.util.VelocityPdf;
import ma.zy.stocky.ws.dto.commun.StockDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zy.stocky.service.facade.admin.commun.ProduitAdminService ;
import ma.zy.stocky.bean.core.commun.Produit ;
import ma.zy.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zy.stocky.bean.core.commun.Depot ;

import java.util.List;
@Service
public class StockAdminServiceImpl extends AbstractServiceImpl<Stock, StockCriteria, StockDao> implements StockAdminService {
    public static final String TEMPLATE = "template/stock.vm";
    public static final String FILE_NAME = "stock.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{




    ATTRIBUTES.add(new Attribute("quantite","BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(StockDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }





    public List<Stock> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<Stock> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Stock.class, StockSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public StockAdminServiceImpl(StockDao dao) {
        super(dao);
    }

}
