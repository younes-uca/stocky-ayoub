package ma.zy.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zy.stocky.bean.core.entree.EntreeProduit;
import ma.zy.stocky.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface EntreeProduitAdminService extends  IService<EntreeProduit,EntreeProduitCriteria>  {

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    List<EntreeProduit> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);



}
