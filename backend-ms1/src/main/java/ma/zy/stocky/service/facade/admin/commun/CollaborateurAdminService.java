package ma.zy.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zy.stocky.bean.core.commun.Collaborateur;
import ma.zy.stocky.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zy.stocky.zynerator.service.IService;



public interface CollaborateurAdminService extends  IService<Collaborateur,CollaborateurCriteria>  {
    Collaborateur findByUsername(String username);
    boolean changePassword(String username, String newPassword);




}
