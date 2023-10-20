package ma.zy.stocky.service.impl.admin.sortie;


import ma.zy.stocky.bean.core.sortie.SortieProduit;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitCriteria;
import ma.zy.stocky.dao.facade.core.sortie.SortieProduitDao;
import ma.zy.stocky.dao.specification.core.sortie.SortieProduitSpecification;
import ma.zy.stocky.service.facade.admin.sortie.SortieProduitAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zy.stocky.service.facade.admin.commun.CollaborateurAdminService ;
import ma.zy.stocky.bean.core.commun.Collaborateur ;
import ma.zy.stocky.service.facade.admin.sortie.SortieProduitItemAdminService ;
import ma.zy.stocky.bean.core.sortie.SortieProduitItem ;

import java.util.List;
@Service
public class SortieProduitAdminServiceImpl extends AbstractServiceImpl<SortieProduit, SortieProduitCriteria, SortieProduitDao> implements SortieProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public SortieProduit create(SortieProduit t) {
        super.create(t);
        if (t.getSortieProduitItems() != null) {
                t.getSortieProduitItems().forEach(element-> {
                    element.setSortieProduit(t);
                    sortieProduitItemService.create(element);
            });
        }
        return t;
    }

    public SortieProduit findWithAssociatedLists(Long id){
        SortieProduit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSortieProduitItems(sortieProduitItemService.findBySortieProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        sortieProduitItemService.deleteBySortieProduitId(id);
    }


    public void updateWithAssociatedLists(SortieProduit sortieProduit){
    if(sortieProduit !=null && sortieProduit.getId() != null){
            List<List<SortieProduitItem>> resultSortieProduitItems= sortieProduitItemService.getToBeSavedAndToBeDeleted(sortieProduitItemService.findBySortieProduitId(sortieProduit.getId()),sortieProduit.getSortieProduitItems());
            sortieProduitItemService.delete(resultSortieProduitItems.get(1));
            ListUtil.emptyIfNull(resultSortieProduitItems.get(0)).forEach(e -> e.setSortieProduit(sortieProduit));
            sortieProduitItemService.update(resultSortieProduitItems.get(0),true);
    }
    }



    public SortieProduit findByReferenceEntity(SortieProduit t){
        return  dao.findByReference(t.getReference());
    }

    public List<SortieProduit> findByCollaborateurId(Long id){
        return dao.findByCollaborateurId(id);
    }
    public int deleteByCollaborateurId(Long id){
        return dao.deleteByCollaborateurId(id);
    }






    public void configure() {
        super.configure(SortieProduit.class, SortieProduitSpecification.class);
    }


    @Autowired
    private CollaborateurAdminService collaborateurService ;
    @Autowired
    private SortieProduitItemAdminService sortieProduitItemService ;

    public SortieProduitAdminServiceImpl(SortieProduitDao dao) {
        super(dao);
    }

}
