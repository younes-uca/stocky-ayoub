package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.CategorieProduit;
import ma.zy.stocky.dao.criteria.core.commun.CategorieProduitCriteria;
import ma.zy.stocky.zynerator.service.IService;

import ma.zy.stocky.ws.dto.commun.CategorieProduitDto;
import org.springframework.http.HttpEntity;


public interface CategorieProduitAdminService extends  IService<CategorieProduit,CategorieProduitCriteria>  {



    HttpEntity<byte[]> createPdf(CategorieProduitDto dto) throws Exception;

}
