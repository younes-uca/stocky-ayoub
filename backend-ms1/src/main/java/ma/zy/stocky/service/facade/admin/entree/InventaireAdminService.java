package ma.zy.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zy.stocky.bean.core.entree.Inventaire;
import ma.zy.stocky.dao.criteria.core.entree.InventaireCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface InventaireAdminService extends  IService<Inventaire,InventaireCriteria>  {

    List<Inventaire> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);



}
