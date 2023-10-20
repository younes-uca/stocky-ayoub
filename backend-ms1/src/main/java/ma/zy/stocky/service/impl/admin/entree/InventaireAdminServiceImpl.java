package ma.zy.stocky.service.impl.admin.entree;


import ma.zy.stocky.bean.core.entree.Inventaire;
import ma.zy.stocky.dao.criteria.core.entree.InventaireCriteria;
import ma.zy.stocky.dao.facade.core.entree.InventaireDao;
import ma.zy.stocky.dao.specification.core.entree.InventaireSpecification;
import ma.zy.stocky.service.facade.admin.entree.InventaireAdminService;
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
import ma.zy.stocky.service.facade.admin.entree.InventaireItemAdminService ;
import ma.zy.stocky.bean.core.entree.InventaireItem ;

import java.util.List;
@Service
public class InventaireAdminServiceImpl extends AbstractServiceImpl<Inventaire, InventaireCriteria, InventaireDao> implements InventaireAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Inventaire create(Inventaire t) {
        super.create(t);
        if (t.getInventaireItems() != null) {
                t.getInventaireItems().forEach(element-> {
                    element.setInventaire(t);
                    inventaireItemService.create(element);
            });
        }
        return t;
    }

    public Inventaire findWithAssociatedLists(Long id){
        Inventaire result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setInventaireItems(inventaireItemService.findByInventaireId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        inventaireItemService.deleteByInventaireId(id);
    }


    public void updateWithAssociatedLists(Inventaire inventaire){
    if(inventaire !=null && inventaire.getId() != null){
            List<List<InventaireItem>> resultInventaireItems= inventaireItemService.getToBeSavedAndToBeDeleted(inventaireItemService.findByInventaireId(inventaire.getId()),inventaire.getInventaireItems());
            inventaireItemService.delete(resultInventaireItems.get(1));
            ListUtil.emptyIfNull(resultInventaireItems.get(0)).forEach(e -> e.setInventaire(inventaire));
            inventaireItemService.update(resultInventaireItems.get(0),true);
    }
    }



    public Inventaire findByReferenceEntity(Inventaire t){
        return  dao.findByReference(t.getReference());
    }

    public List<Inventaire> findByCollaborateurId(Long id){
        return dao.findByCollaborateurId(id);
    }
    public int deleteByCollaborateurId(Long id){
        return dao.deleteByCollaborateurId(id);
    }






    public void configure() {
        super.configure(Inventaire.class, InventaireSpecification.class);
    }


    @Autowired
    private CollaborateurAdminService collaborateurService ;
    @Autowired
    private InventaireItemAdminService inventaireItemService ;

    public InventaireAdminServiceImpl(InventaireDao dao) {
        super(dao);
    }

}
