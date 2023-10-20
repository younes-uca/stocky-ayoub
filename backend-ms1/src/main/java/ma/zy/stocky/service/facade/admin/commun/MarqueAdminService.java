package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.Marque;
import ma.zy.stocky.dao.criteria.core.commun.MarqueCriteria;
import ma.zy.stocky.zynerator.service.IService;

import ma.zy.stocky.ws.dto.commun.MarqueDto;
import org.springframework.http.HttpEntity;


public interface MarqueAdminService extends  IService<Marque,MarqueCriteria>  {



    HttpEntity<byte[]> createPdf(MarqueDto dto) throws Exception;

}
