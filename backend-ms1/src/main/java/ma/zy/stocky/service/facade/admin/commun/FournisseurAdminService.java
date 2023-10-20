package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.Fournisseur;
import ma.zy.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zy.stocky.zynerator.service.IService;

import ma.zy.stocky.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;


public interface FournisseurAdminService extends  IService<Fournisseur,FournisseurCriteria>  {



    HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception;

}
