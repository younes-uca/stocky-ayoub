package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.Stock;
import ma.zy.stocky.dao.criteria.core.commun.StockCriteria;
import ma.zy.stocky.zynerator.service.IService;

import ma.zy.stocky.ws.dto.commun.StockDto;
import org.springframework.http.HttpEntity;


public interface StockAdminService extends  IService<Stock,StockCriteria>  {

    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<Stock> findByDepotId(Long id);
    int deleteByDepotId(Long id);


    HttpEntity<byte[]> createPdf(StockDto dto) throws Exception;

}
