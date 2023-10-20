package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.Depot;
import ma.zy.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zy.stocky.zynerator.service.IService;

import ma.zy.stocky.ws.dto.commun.DepotDto;
import org.springframework.http.HttpEntity;


public interface DepotAdminService extends  IService<Depot,DepotCriteria>  {



    HttpEntity<byte[]> createPdf(DepotDto dto) throws Exception;

}
