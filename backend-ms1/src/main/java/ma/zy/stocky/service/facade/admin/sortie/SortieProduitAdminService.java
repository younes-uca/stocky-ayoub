package ma.zy.stocky.service.facade.admin.sortie;

import java.util.List;
import ma.zy.stocky.bean.core.sortie.SortieProduit;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface SortieProduitAdminService extends  IService<SortieProduit,SortieProduitCriteria>  {

    List<SortieProduit> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);



}
